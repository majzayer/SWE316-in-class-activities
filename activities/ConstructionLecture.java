public void f(String s, ArrayList<String> arr) {
    s.concat("b");  // String operations
    s += "c";       // String concatenation
    arr.add("d");   // Modify the ArrayList
}

public static void main(String[] args) {
    String t = "a";
    ArrayList<String> tarr = new ArrayList<>();
    tarr.add(t);

    f(t, tarr);
}
