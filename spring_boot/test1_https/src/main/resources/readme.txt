https配置
#1. 使用jdk自带工具生成证书 
#   执行命令后 经过一系列的交互提问 会在当前目录中生成 keystore123.p12文件
keytool -genkey -alias abc    
-storetype PKCS12    
-keyalg RSA     
-keysize 2048     
-keystore keystore123.p12    
-validity 3650  

# 将证书放入项目中



