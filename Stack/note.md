![](https://cdn.jsdelivr.net/gh/tyraelHqy/cloudimg@master/img/20200821160145.png)
![](https://cdn.jsdelivr.net/gh/tyraelHqy/cloudimg@master/img/20200821160829.png)
![](https://cdn.jsdelivr.net/gh/tyraelHqy/cloudimg@master/img/20200821161700.png)
![](https://cdn.jsdelivr.net/gh/tyraelHqy/cloudimg@master/img/20200821161900.png)
![](https://cdn.jsdelivr.net/gh/tyraelHqy/cloudimg@master/img/20200821165724.png)

## Leetcode 20题：

给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

**示例 1:**

```
输入: "()"
输出: true
```

**示例 2:**

```
输入: "()[]{}"
输出: true
```

**示例 3:**

```
输入: "(]"
输出: false
```

**示例 4:**

```
输入: "([)]"
输出: false
```

**示例 5:**

```
输入: "{[]}"
输出: true
```

栈顶元素反映了在**嵌套**的层次关系中，**最近**的需要匹配的元素