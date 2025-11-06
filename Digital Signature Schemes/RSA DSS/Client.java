    import java.io.*;
    import java.net.*;
    import java.util.*;

    public class Client{
        public static void main(String args[]) throws IOException{
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost",4444);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            int n = Integer.parseInt(br.readLine());
            int e = Integer.parseInt(br.readLine());
            System.out.println("Public Key:" + e+ "," +n);
            while(true){
            int len = Integer.parseInt(br.readLine());
            System.out.println("Length:"+len);
            StringBuilder M = new StringBuilder();
            for(int i=0; i<len;i++){
                int ch = Integer.parseInt(br.readLine());
                int m = CommonUtils.modPow(ch,e,n);
                M.append((char)m);
            }
            String msg = br.readLine();
            System.out.println("Message:"+M);
            if(msg.equals(M.toString())){
                System.out.println("Sign verified");
            }
            else{
                System.out.println("Not Verified");
            }
            }
        }
    }