import java.util.ArrayList;

public class ClosedGroup extends Group{

    private static ArrayList<User> Members = new ArrayList<>();

    static ClosedGroup g2 = new ClosedGroup("JavaExperts Closed group","For Java dummies");

    public ClosedGroup(String name, String description)
    {
        super(name,description);
    }

//adding a member in closed group
    public static void AddMember(User user)
    {
        boolean friends = false;

        if (Members.isEmpty())
        {
            Members.add(user);
            User.arrayListOfGroups.add(g2);
            System.out.println(user.getName() + " has been successfully enrolled in group " + name);

        }
        else
        {
            for (User member : Members)
            {
                if (member.isHeMyFriend(user))
                {
                    friends = true;
                    break;
                }
            }
            if (friends)
            {
                Members.add(user);
                User.arrayListOfGroups.add(g2);
                System.out.println(user.getName() + " has been successfully enrolled in group " + name);
            }
            else
            {
                System.out.println("FAILED : " + user.getName() + " can not be enrolled in " + name);
            }
        }
    }


    public ArrayList<User> getMembers()
    {
        return Members;
    }
}