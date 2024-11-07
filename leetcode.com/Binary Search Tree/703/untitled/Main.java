public class Main {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(7, new int[] { 5, 2, 10 });
        System.out.println(kthLargest.add(7));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(8));
        System.out.println(kthLargest.add(12));
        System.out.println(kthLargest.add(13));
        System.out.println(kthLargest.add(11));
    }
}
