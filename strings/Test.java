package strings;

public class Test {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("hello");

        sb.append(" world").insert(0, "new ");

        for(int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }

        //
    }

}
