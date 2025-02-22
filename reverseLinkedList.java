// Sudo code for Reverse of a Linked List

public ListNode reverseList(ListNode head)
    {
        ListNode prev=null,follow=head,cur=head;
        if(head==null)
        return null;
        if(head.next==null)
        return head;
        while(cur!=null)
        {
            follow=follow.next;
            cur.next=prev;
            prev=cur;
            cur=follow;
        }
        return prev;
    }
