
import java.util.ArrayList;
import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        class Account {
            String acc;
            int followingNum;
            ArrayList<String> FollowingNams;

            public String getAcc() {
                return acc;
            }

            public void setAcc(String acc) {
                this.acc = acc;
            }

            public int getFollowingNum() {
                return followingNum;
            }

            public void setFollowingNum(int followingNum) {
                this.followingNum = followingNum;
            }

            public ArrayList<String> getFollowingNams() {
                return FollowingNams;
            }

            public void setFollowingNams(ArrayList<String> followingNams) {
                FollowingNams = followingNams;
            }
        }
        class Post{
            String acc;
            int time;
            String state;
            String text;

            public String getAcc() {
                return acc;
            }

            public void setAcc(String acc) {
                this.acc = acc;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
        Scanner scanner = new Scanner(System.in);
        //دریافت تعداد کل کاربران
        int numOfUsers =scanner.nextInt();
        ArrayList<Account> users =new ArrayList<>();
        for (int i = 0; i <numOfUsers ; i++) {
            Account account = new Account();
            account.acc=scanner.next();
            account.followingNum= Integer.valueOf(scanner.next());
            ArrayList<String> newList=new ArrayList<>();
            if (account.followingNum>0) {
                for (int j = 0; j <account.followingNum ; j++) {
                    String name=scanner.next();
                    System.out.println(name);
                    newList.add(name);
                }
            }
            else {
                scanner.nextLine();
            }
            account.FollowingNams=newList;
            users.add(account);
        }
        //دریافت تعداد پست ها
        int postNum=scanner.nextInt();
        ArrayList<Post> allPost=new ArrayList<>();
        for (int i = 0; i <postNum ; i++) {
            Post post =new Post();
            if (i==0)
            scanner.nextLine();
            String[] newString = scanner.nextLine().split(" ",4);
            post.acc=newString[0];
            post.time=Integer.valueOf(newString[1]);
            post.state=newString[2];
            post.text=newString[3];

            allPost.add(post);
        }
        String timeLineFor=scanner.next();
        //مرتب سازی پست
            int a, b, maxIndex;
            int n = allPost.size();
            for (a = 0; a < n - 1; a++) {
                maxIndex = a;
                for (b = a + 1; b < n; b++)
                    if (allPost.get(b).time > allPost.get(maxIndex).time)
                        maxIndex = b;
                if (maxIndex != a) {
                    Post tempPost = allPost.get(a);
                    allPost.set(a,allPost.get(maxIndex));
                    allPost.set(maxIndex,tempPost);
                }
            }
            //پیدا کردن کاربری که تایم لاین برایش باید به نمایش در بیاید
        Account accTimeLine=new Account();
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).acc.equals(timeLineFor)) accTimeLine=users.get(i);
        }

        //نمایش تایم لاین
        for (int i = 0; i <allPost.size() ; i++) {
            if (allPost.get(i).acc.equals(accTimeLine.acc)
                    || allPost.get(i).state.equals("true")
                    || isIn(allPost.get(i).acc,accTimeLine.FollowingNams) ) {
                System.out.println(allPost.get(i).acc + " " + allPost.get(i).time + " " + allPost.get(i).text);
            }
        }
    }
    //مرتب سازی پست ها
    private static boolean isIn (String name,ArrayList<String> list){
        boolean res =false;
        for (String s:list) {
            if (s.equals(name)) res=true;
        }
        return res;
    }
}
