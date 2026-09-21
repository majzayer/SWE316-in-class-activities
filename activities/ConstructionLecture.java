public static void f(String s, ArrayList<String> arr) {
    s.concat("b"); 
    s += "c";     
    arr.add("d"); 
}

public static void main(String[] args) {
    String t = "a";
    ArrayList<String> tarr = new ArrayList<>();
    tarr.add(t);

    f(t, tarr);
}
