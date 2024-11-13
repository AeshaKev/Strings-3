// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
         

        Stack<Integer> st = new Stack<>();
        int currnum = 0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                currnum = currnum * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c!=' ' )|| i == s.length() - 1)
            {
                if(lastSign == '+')
                {
                    st.push(currnum);
                }
                else if(lastSign == '-')
                {
                    st.push(-currnum);
                }
                else if(lastSign == '*')
                {
                    int popped = st.pop();
                    st.push( popped* currnum);
                }
                else if(lastSign == '/')
                {
                    int popped = st.pop();
                    st.push(popped/ currnum);
                }
                currnum = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!st.isEmpty())
        {
            result += st.pop();
        }
        return result;

    }
}
