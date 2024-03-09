Solution、Solution1、Solution2 中心扩展法，比较最大值

Solution3 动态规划
动态规划方程： 
- if: j - i < 2:  dp[i][j] = (s.charAt(i) == s.charAt(j));
- if: i = j :  dp[i][j] = true;
- else: dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);

如何遍历: 
- 最外层: len: 2~n  
- 内层: i: 0~n
- j = i -1 + len;
