# The Hamsaa Timeline Problem
Hamsaa is a problem-solution based social network, (similar to stack overflow, quite different though) which users can ask problems and get answers on them. In Hamsaa (Our social network), each user can follow many other users. Users can post a problem or an idea to solve others’ problems and each post can have 2 states: only visible to their friends or visible to everyone. Assume we have the list of some users and their followings, and we have the list of the posts that each user has posted on Hamsaa (For simplicity, we assume users can only post problems). Write a program to create the timeline that a given user sees.


# Input
In the first line there is 0≤𝑛≤1,000 as the number of users in the network. Following that, there is the username and the 0≤𝑓≤1,000 as the number of other users that this user follows. At the next line there is the list of usernames of the users that this user follows. (If a user doesn’t follow anyone, there is a blank line) After the input of all the users and the people they follow, there comes a 0≤𝐾≤1,000 for the number of posts in the network. Each post is written in a single line starting with the username of the user posting, the timestamp which the post was posted on, a text value “true” if the post is public and “false” if the post is private and the rest of the line contains the post text. At the last line you will receive the username of the user which we want you to create the timeline for.


# Output
Calculate and print the timeline of the user such that the posts shown to the user are sorted chronologically (newest to oldest). Each line represents a post starting with the username followed by the timestamp and the post itself.


# Sample Input 1
3

msadjad

2

omidjm noghtegi

omidjm

0

noghtegi

1

msadjad

5

msadjad 10 true Can you see my post now?

noghtegi 3 false I love Hamsaa

omidjm 7 false Why can’t I follow anyone

msadjad 8 false Follow me omid, it is fun

omidjm 9 true There is no posts here

noghtegi

# Sample Output 1
msadjad 10 Can you see my post now?

omidjm 9 There is no posts here

msadjad 8 Follow me omid, it is fun

noghtegi 3 I love Hamsaa




# Sample Input 2

3

msadjad

2

omidjm noghtegi

omidjm

0

noghtegi

1

msadjad

5

msadjad 10 true Can you see my post now?

noghtegi 3 false I love Hamsaa

omidjm 7 false Why can’t I follow anyone

msadjad 8 false Follow me omid, it is fun

omidjm 9 true There is no posts here

omidjm

# Sample Output
msadjad 10 Can you see my post now?

omidjm 9 There is no posts here

omidjm 7 Why can’t I follow anyone

#

Note 1. the input posts are not sorted by timestamp.

Note 2. Two posts might have the same timestamp, in such case the one that comes first should appear first in the output.

Note 3. Users can see their own posts.
