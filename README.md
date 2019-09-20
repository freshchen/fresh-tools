# fresh-tools

本仓库用于存放常用工具，脚本，模板。便于提升工作效率的。

### docker-compose

docker-compose up -d tools (使用docker-compose部署常用工具)

### java-tools

http://localhost:1994/swagger-ui.html 在线常用的加密解密工具

### script/common

脚本常用方法收藏

### script/certificate

generate_certificate_and_keystore.sh (生成根证书服务端客户端证书以及导入keystore)

check_local_port_certificate.sh	(端口证书以及客户端证书过期检查)

postgres_get_server_cert.py	(postgres数据库端口证书检查)

### script/openstack

create_loop_dev_for_openstack_cinder.sh	(虚拟块存储文件创建逻辑卷)

host_add_route_to_openstack_instance.sh	(主机到虚拟机加路由)

openstack-python-client-api.py (常用组件的puthon调用接口)

