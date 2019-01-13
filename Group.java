import java.util.ArrayList;

public class Group {

    protected static String name;
    protected String description;
    protected static ArrayList<User> arrayGroup = new ArrayList<>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //creating a group
    private static Group g1 = new Group("JavaExperts","For Java dummies");



    /**
     * Checks if a user is member of the group
     * @param aUser
     * @return
     */
    private static boolean isHeMember(User aUser) {
        boolean flag = false;

        for(User u : arrayGroup)
            if(u.equals(aUser))
                flag = true;

        return flag;
    }

    /**
     * Adds a user to the group
     * @param aUser
     *
     */
    public static void addToGroup(User aUser) {
        if(isHeMember(aUser))
            System.out.println(aUser.getName() + " is already member of the IT Experts Group.");
        else {
            arrayGroup.add(aUser);
            User.arrayListOfGroups.add(g1);
            System.out.println(aUser.getName() + " has successfully enrolled in group " + name);
        }

    }

    /**
     * Prints the users of the group
     *
     */
    public static void printInfo() {
        String text = "";
        text += ("Members of group " + name + "\n");
        int count = 0;

        for(User u : arrayGroup) {
            count ++;
            text += count + ": " + u.getName() + "\n";
        }
        System.out.println(text);
    }

    public Group getGroupName() {
        return g1;
    }

    public ArrayList<User> getMembers()
    {
        return arrayGroup;
    }
}