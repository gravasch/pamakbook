import java.util.ArrayList;

public class User {


    private String name;
    private String email;
    static ArrayList<User> pamakBookUsers = new ArrayList<>();
    private ArrayList<User> arrayListOfUserFriends = new ArrayList<>();
    static ArrayList<Group> arrayListOfGroups = new ArrayList<>();
    static ArrayList<Post> arrayListOfUserPost = new ArrayList<>();
    static ArrayList<User> SuggestedFriends = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Check if the new user already exist:
     */
    public void alreadyExistingUser(User aUser) {
        boolean exist = false;

        if (!this.equals(aUser)) {
            //Checks if the user (aUser) is in this.pamakbook user list
            for (User u : this.pamakBookUsers) {
                if (u.equals(aUser)) {
                    exist = true;
                    break;
                }
            }
        }
        if (exist)
            System.out.println("You have already signed up.");
            //Checks if user tries to sing up again
        else {
            this.pamakBookUsers.add(aUser);
            System.out.println(name + ", added successfully.");
        }
    }

    /**
     * Check if the user: A is in a friend list of another user: B
     * @param aUser
     * @return
     */
    public boolean isHeMyFriend(User aUser) {
        boolean isHeMyFriendFlag = false;

        //Checks if the user(aUser) is not the same with this.user
        if(!this.equals(aUser)) {
            //Checks if the user (aUser) is in this.user friend list
            for(User u: this.arrayListOfUserFriends) {
                if(u.equals(aUser)) {
                    isHeMyFriendFlag = true;
                    break;
                }
            }
        }

        return isHeMyFriendFlag;
    }

    /**
     * Add user to another user friend list
     * @param aUser
     */
    public void addFriend(User aUser) {
        //Checks if the user is already in his friend list
        if(this.isHeMyFriend(aUser))
            System.out.println("You already have this friend in your list.");
            //Checks the user try to add himself in his friend list
        else {
            if(this.equals(aUser)) {
                System.out.println("You can't add yourself in your friend list.");
                return;
            }
            else{
                this.arrayListOfUserFriends.add(aUser);
                aUser.arrayListOfUserFriends.add(this);
            }
            System.out.println(this.getName() + " and " + aUser.getName() + " are now friends!");
        }
    }

    /**
     * Finds the mutual friends of two users
     * @param //aUser
     * @return

    public void mutualFriends(User aUser) {
        ArrayList<User> temp = new ArrayList<>();

        int count = 0;
        String text = "";
        text += "Mutual friends of " + this.getName() + " and " + aUser.getName() + "\n";

        //Checks if the user has selected himself
        if(this.name.equals(aUser.getName()))
            System.out.println("\n");
        else {
            //Find the mutual
            for(User u1 : this.arrayListOfUserFriends)
                for(Object u2 : aUser.arrayListOfUserFriends) {
                    if(u1.getName().equals(getName()) && u1.getEmail().equals(getEmail())) {
                        temp.add((User) u2);
                        count ++;
                        text += count + ": " + getName() + "\n";
                        break;
                    }
                }
            System.out.println(text);
        }

        for(User user : temp)
        {
            System.out.println(user + "\n");
        }
    }*/

    public void SuggestedFriends()
    {

        if (arrayListOfUserFriends.isEmpty()){
            System.out.println("Your Friend List is empty. Check PamakBook users");
            for (User u : pamakBookUsers){
                System.out.println(u.getName());
            }

    }
        else {
            for (User friend : arrayListOfUserFriends) {
                for (User friend_of_friend : friend.getArrayListOfUserFriends()) {
                    boolean condition = !friend_of_friend.equals(this) && !friend_of_friend.isHeMyFriend(this);
                    if (condition) {
                        SuggestedFriends.add(friend_of_friend);
                    }
                }
            }
        }
    }


    /**
     * It prints the friends of the user
     */
    public void printFriends() {
        String text = "";
        text += this.getName() + " is friend with: " + "\n";
        for(User u : this.arrayListOfUserFriends)
            text += u.getName() + "\n";

        System.out.println(text);
    }

    /**
     * It prints the groups of the user
     */
    public void printGroups() {
        System.out.println("Groups");
        System.out.println("======");
        for(Group g : this.getArrayListOfGroups())
              System.out.println(g + "\n");
        System.out.println("======");
    }

    /**
     * It prints the posts of the users
     */
    public void printPosts() {

        for(Post p : arrayListOfUserPost)
            System.out.println(p.getDate() + " ~ " + getName() + " : " + p.getText());

    }

    /*
    public void SortPosts(){

		Collections.sort(arrayListOfUserPost);
	}
	*/

    public ArrayList<User> getArrayListOfUserFriends() {  return arrayListOfUserFriends;    }

    public static ArrayList<Post> getArrayListOfUserPost() {  return arrayListOfUserPost;    }

    public ArrayList<Group> getArrayListOfGroups() { return arrayListOfGroups;    }

    public ArrayList<User> getSuggestedFriends()  { return SuggestedFriends;  }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static void addToArrayListOfUserPost(Post post) {

            arrayListOfUserPost.add(post);
            }





    /*public static void SuggestedFriends(User aUser, User bUser){

        bUser.mutualFriends(aUser);
    }*/

}