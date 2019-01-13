import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //creating a list of pamakBook users
        User u1 = new User("Yannis", "mai1769@uom.edu.gr");
        User u2 = new User("Petros", "mai1236@uom.edu.gr");
        User u3 = new User("Anna", "mai14850@uom.edu.gr");
        User u4 = new User("Stella", "mai1547@uom.edu.gr");
        User u5 = new User("Nikos", "mai2569@uom.edu.gr");
        User u6 = new User("Kalianthi", "mai4785@uom.edu.gr");

        //creating some posts by pamakBook users
        User.pamakBookUsers.add(u1);
        User.pamakBookUsers.add(u2);
        User.pamakBookUsers.add(u3);
        User.pamakBookUsers.add(u4);
        User.pamakBookUsers.add(u5);
        User.pamakBookUsers.add(u6);



        //creating some posts by pamakBook users
        String date = "24/08/2018 17:14:56";
        String text = "My code ran without a bug!!!\n";
        Post post = new Post(date,u1,text);
        u1.addToArrayListOfUserPost(post);

        date = "10/09/2018 16:15:42";
        text = "Help me!!!\n";
        post = new Post(date,u2,text);
        u2.addToArrayListOfUserPost(post);

        date = "07/10/2018 16:15:15";
        text = "Love Javing!\n";
        post = new Post(date,u3,text);
        u3.addToArrayListOfUserPost(post);

        date = "20/11/2018 16:15:15";
        text = "Merry Christmas\n";
        post = new Post(date,u4,text);
        u4.addToArrayListOfUserPost(post);



        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\033[1m Welcome to PamakBook \033[0m");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Please, type your username and email:");


        //creating a new user with name and email
        String name = reader.readLine();
        String email = reader.readLine();
        User NewUser = new User(name, email);
        NewUser.alreadyExistingUser(NewUser);


        //menu with the PamakBook operations
        System.out.println("Enjoy PamakBook! \n");



        System.out.println("\033[1m Menu \033[0m:");
        System.out.println("==============");
        System.out.println("1. PamakBook users");
        System.out.println("2. Friends list");
        System.out.println("3. New post?");
        System.out.println("4. Become member in 'IT Experts Group' , (A group for IT freaks)");
        System.out.println("5. Become member in 'JavaExperts Closed group' , (For Java dummies)");
        System.out.println("6. Suggested friends! - based on mutual friends");
        System.out.println("X. for Log out");
        System.out.println("==============\n");

        String choice;
        choice = reader.readLine();

        while (!choice.equals("X")) {

            if (choice.equals("1")) {
                //showing already registered pamakbookusers
                System.out.println("PamakBookUsers");
                System.out.println("==============");
                for (User users : User.pamakBookUsers) {
                    System.out.println(users.getName() + " ~ " + users.getEmail());
                }
                System.out.println("==============\n");

                System.out.println("Do you want to add as friend any PamakBook user above?" + "Press 1 for Yes.");
                String ch = reader.readLine();

                Integer inc = 1;
                if (ch.equals("1")) {

                    System.out.println("Press the number id of the person you want to become friends");
                    for (User users : User.pamakBookUsers) {
                        System.out.println(inc++ + ". " + users.getName() + " ~ " + users.getEmail());
                    }
                    System.out.println("Please select friend typing his number");
                    String new_friend = reader.readLine();

                    switch (new_friend) {
                        case "1":
                            NewUser.addFriend(u1);
                            break;
                        case "2":
                            NewUser.addFriend(u2);
                            break;
                        case "3":
                            NewUser.addFriend(u3);
                            break;
                        case "4":
                            NewUser.addFriend(u4);
                            break;
                        case "5":
                            NewUser.addFriend(u5);
                            break;
                        case "6":
                            NewUser.addFriend(u6);
                            break;
                        case "7":
                            NewUser.addFriend(NewUser);
                    }
                    System.out.println("Your friends list updated!");

                    System.out.println("==============");
                    System.out.println("Friends List");
                    System.out.println("==============\n");
                    NewUser.printFriends();

                }
            }
            else if (choice.equals("2")) {
                //add a new friend from the pamakbookusers list
                System.out.println("Friends List");
                System.out.println("==============");
                NewUser.printFriends();
                System.out.println("==============");
            }
            else if (choice.equals("3"))
            {
                //creating a new post

                System.out.println("Type your post:");

                date = Post.Timestamp();
                text = reader.readLine();
                post = new Post(date,NewUser,text);
                NewUser.addToArrayListOfUserPost(post);

                //displaying the posts

                System.out.println("\nPosts");
                System.out.println("=====");

                for (Post p : User.arrayListOfUserPost) {
                    System.out.println(p.toString());
                }



            }
            else if (choice.equals("4"))
            {
                //adding some PamakBook users in Group
                Group.addToGroup(u2);
                Group.addToGroup(u5);

                //get into a group
               Group.addToGroup(NewUser);
               Group.printInfo();

            }
            else if (choice.equals("5"))
            {
                //adding a user in closed group
                ClosedGroup.AddMember(u1);
                ClosedGroup.AddMember(NewUser);
                ClosedGroup.printInfo();

            }
            else if (choice.equals("6"))
            {
                u1.addFriend(u2);
                u2.addFriend(u3);
                u3.addFriend(u4);

                System.out.println("Suggested Friends based on mutual friends");
                System.out.println("=================");

                for(User user : User.pamakBookUsers)
                {
                    user.SuggestedFriends();
                }

                for(User user : User.SuggestedFriends)
                {
                    System.out.println(user.getName());
                }

            }


            System.out.println("What's your next choice from our menu?");
            choice = reader.readLine();


        }
        System.out.println("Hope you enjoyed it!");
    }
}

