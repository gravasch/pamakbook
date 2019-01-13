# pamakbook

Consider participating in the development team of a special social networking system (PamakBook). 
You are asked to do the analysis and initial design of the system, taking into account the following information: 
    User 
    The user of the popular PamakBook social network is characterized by his name and e-mail. Each user maintains a list of other social network users with whom they are "friends". 
    It maintains another list of the groups in which it is registered.  
    The group is characterized by its name, its description and the list of its members. 
    A special group class is the ClosedGroup where a user can only register if they are "friends" with an existing member of the group (this limit does not apply to the first member of a closed group). 
    Each user also maintains a list of their posts (posts). Each post includes as a time the time stamp for the time of publication, the post text, and the user it created. 
    The User class must have a sophisticated computation function and return a list of suggested friends (Featured Friends). 
    Suggested friends can come in the following ways: 
    a) Based on user's "friendships": If user A has friends B and D, and B has their friends A, D and E then the system for user A should return as his recommended friend E. whereas, (This rule complies with the principle of "triangular closeness" according to which in social networks users tend to create friendships that "close" triangles, ie a user wants to make friends with friends of his friends).
    b) Based on the groups in which it participates: If a user A participates in a group (not a "closed" group) then all members of the group who are not friends of A are included in the proposed friends. For the example below, suggested friends for A will be C and D.Especially for a "closed" group, the proposed friends for a user A belonging to it should not to exceed two (if the list of suggested group-based friends includes more than two users, the first two will be selected based on their alphabetical classification) 
    c) Based on the posts: in the special social networking system PamakBook proposed friends for someone A, are all users who have posted posts on the same day I made his last post. For example, if A performed his last posting on December 15, 2016, proposed friends will be users B and C if they have make a post on the same day.The user can choose to export suggested friends from the system by specifying it criterion (a, b, c) that wants to be used to find the proposed friends. Then the system displays the names of the suggested friends.
