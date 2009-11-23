Tutorial para montar um de alta disponibilidade com DRBD, PostgreSQL e Heartbeat. Assume-se que o utilizador dispõe de uma estrututura de virtualização com duas máquinas virtuais a funcionar.

NOTA: Todas o software deve ser instalado e configurado em AMBAS as máquinas virtuais e devem ser exactamente iguais (excepção óbvia aos endereços de cada máquina). Outra alternativa (menos recomendável) é fazer tudo numa só máquina e depois copiá-la. Mas atenção que no final haverá configurações a fazer. Este tutorial assume que se está a seguir o modelo duas máquinas.

/*****************************/
/*********    DRBD    ********/
/*****************************/

1ª - Instalar o DRBD, usando o método preferido (gestor de pacotes, compilar de source, etc).

2º - Criar uma partição para suportar o DRBD.

3º - Editar o ficheiro de configuração do DRBD que se encontra em /etc/drbd.conf

	- Certificar-se que o ficheiro contém a seguinte informação:
	
		# A secção global é obrigatória e deve conter sempre informação a respeito do usage-count que
		# apenas faz estatísticas sobre as versões do DRBD usadas.
		
		global {
		    usage-count yes;
		}

		# Usar o Protocolo C, que é um protocolo de replicação sincronizada. Ou seja todas as 
		# escritas no disco primário só são dadas como completas quando estiverem no disco local
		# e no disco remoto.

		common {
		  protocol C;
		}

		# Configurar o recurso a ser utilizado, neste caso 'r0', dando-lhe informação das duas
		# máquinas que o vão correr, JeOS-Serv1 e JeOS-Serv2, dando informação dos dispositivos
		# a serem usados, neste caso ambas as máquinas devem usar o disco sda6 e montar o 
		# dispositivo drbd1. 

		resource r0 {
		  on JeOS-Serv1 {
		    device      /dev/drbd1;
		    disk        /dev/sda6;		# Definir para a partição criada no passo 2
		    address     10.42.0.100:7789;
		    meta-disk   internal;
		  } 

		  on JeOS-Serv2 {
		    device      /dev/drbd1;
		    disk        /dev/sda6;		# Definir para a partição criada no passo 2
		    address     10.42.0.200:7789;
		    meta-disk   internal;
		  } 
		}
		
	- Obs: O ficheiro /etc/drbd.conf deve ser igual nas duas máqunias que vão correr o serviço. Sugere-se que se copie o ficheiro de uma máquina para a outra através de ssh.
	
4º - Correr os seguintes comandos nos dois nodos:
	
	Este comando inicializa a meta data do dispositivo do DRBD
	- drbdadm create-md r0 
	
	Este comando define a os parâmetros da ligação.
	- drbdadm up r0
	
5º - Correr a primeira sincronização com o comando:

	drbdadm -- --overwrite-data-of-peer primary r0
	
	- Obs: Este comando apenas deve ser corrido numa máquina.

6º - Definir o recurso do DRBD como primário num dos nódos, com o seguinte comando:

		drbdadm primary r0

7º - Montar o recurso do DRBD numa pasta existente com os seguintes comandos.

		mkdir /mnt/db
		mount /dev/drbd1 /mnt/db

	
/*****************************/
/*******  PostgreSQL  ********/
/*****************************/

1ª - Instalar o PostgreSQL, nas duas máquinas, usando o método preferido (gestor de pacotes, compilar de source, etc).
	
2º - Criar o cluster para o postgres
	cd /mnt/db/
	su postgres (é preferível que o cluster pertença a este utilizador por questões de configuração do heartbeat por defeito)
	initdb -D "nome"
	exit (não é necessário fazer mais operações como postgres)
	
	- Obs: Apenas é necessário criar o cluster uma vez, numa única máquina. O DRBD encarregar-se-á de o replicar para a outra máquina.
	
/*****************************/
/******** Heartbeat  *********/
/*****************************/

1ª - Instalar o Heartbeat, nas duas máquinas, usando o método preferido (gestor de pacotes, compilar de source, etc). Instalar também o Heartbeat-gui.

2º - Criar em ambas as máquinas (ou editar) o ficheiro /etc/ha.d/ha.cf de forma a ficar da seguinte maneira:

		# Indique os nomes dos computadores que formam o cluster (deve ser igual ao
		# output do comando "uname -n")

		node JeOS-Serv1
		node JeOS-Serv2

		# Indicar a interface de comunicação a ser usada
		udp eth1

		# Ficheiros de log
		debugfile /var/log/ha-debug
		logfile /var/log/ha-log

		# Frequencia, em segundos, da verificação das maquinas
		keepalive 1

		# Tempo mínimo para declarar a outra máquina como morta
		deadtime 5

		# Utilizar o cluster resource manager (necessário para o gui)
		crm on
		
3º - Reiniciar os serviçoes do Heartbeat usando o comando: 

	/etc/init.d/heartbeat restart
	
4º - Criar (caso necessário) o utilizador "hacluster" no grupo "haclient" e atribuir-lhe uma password à escolha.
	
4º - Arrancar o Heartbeat gui com o comando:
	
	hb_gui
	
	- Obs: É necessário ter um servidor de X na máquina.
	
5º - Utilizar o gui para construir a estrutura, seguindo estes passos:
	1 - Resources > Add New Item > Type: Group > ID: group_drbd0
	2 - Resources > Add New Item > Type: Native > ID: resource_drbd0
		drbd (ocf/heartbeat) : Parameters : drbd_resource r0 (Não esquecer de indicar a Master/Slave ID)
		O gui deverá automaticamente fazer com que surjam duas cópias do recurso.
	2 - Os restantes recursos devem ser adicionados dentro do grupo group_drbd0.
		(Grupo Seleccionado) > Resources > Add New Item > Type:Native >...
		Os Recursos a adicionar são:
		ipaddr : Parameters: ip, cidr_netmask, broadcast
		drbddisk : Parameters : 1 r0
		Filesystem : Parameters : device /dev/drbd1, directory /mnt/bdm, fstype ext3
		pgsql : Parameters : pgdata /mnt/db/"nomeBD", pgctl /opt/PostgreSQL/8.4/bin/pg_ctl, psql /opt/PostgreSQL/8.4/bin/psql, pgport 5432
		
6º - Limpar a estrutura e arrancar o cluster. Resource > Cleanup; Resourse > Start.

/*****************************/
/********* Final  ************/
/*****************************/

A partir de agora agora deverá estar disponível um serviço de alta disponibilidade de PostgresSQL no ip que foi adicionado como recurso.