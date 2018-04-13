# file-cut
##文件切割合并工具
* 基于jdk7以上版本，maven 3 
* 使用mvn package进行打包 
* 切割执行 java  -jar E:\temp\file-cut.jar cut  E:\\temp\\hao.png   参数说明： cut 切割命令  ；E:\\temp\\hao.png 要切割的文件
* 合并文件   java  -jar E:\temp\file-cut.jar join  E:\\temp\\hao.png  参数说明 join 合并命令（可选） E:\\temp\\hao.png 碎片文件必须是和hao.png在同一个目录（也就是说碎片文件在E:\\temp）。最后会生成copy_hao.png的文件，并删除碎片文件
补充说明123 456
