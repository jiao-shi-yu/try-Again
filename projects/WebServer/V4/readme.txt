方法提取：
将读取一行的代码，提取为一个方法，方便重用。

实现：
1. 在ClientHandler中定义方法： readLine(), 读取一行字符串
2. 解析请求行的时候，调用此方法。
3. 后续读取消息头，也调用此方法。