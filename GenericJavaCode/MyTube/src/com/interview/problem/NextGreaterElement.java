package com.interview.problem;


public class NextGreaterElement {
    public static void main(String[] args){
        ListNode num1 = new ListNode(2);
        ListNode num2 = new ListNode(4);
        ListNode num3 = new ListNode(3);

        num1.setNext(num2);
        num2.setNext(num3);



        while (num1.getNext() != null){
            System.out.print(num1.val + " -> ");
            num1 = num1.getNext();
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

        public void setNext (ListNode next){
            this.next = next;
        }
        public ListNode getNext (){
            return this.next;
        }
    }
}



