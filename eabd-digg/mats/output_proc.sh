cat outputs/worker_outp* | grep TOP10NEWS > top10News.txt
cat outputs/worker_outp* | grep TOP10FOLL > top10Followers.txt
cat outputs/worker_outp* | grep FOLLFROM > followersOfUser.txt
cat outputs/worker_outp* | grep VOTESFROM > postsLikedByUser.txt
cat outputs/worker_outp* | grep NEWSFROM > newsFromUser.txt
cat outputs/worker_outp* | grep NEWVOTE > newVote.txt
cat outputs/worker_outp* | grep LOGIN > login.txt
cat outputs/worker_outp* | grep NEWPOST > newPost.txt
cat outputs/worker_outp* | grep RECNEWS > recommendedNews.txt
cat outputs/worker_outp* | grep RECUSERS > recommendedUsers.txt
