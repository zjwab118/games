# 安装docker 
## 使用官方安装脚本自动安装
    curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
## 也可以使用国内 daocloud 一键安装命令
    curl -sSL https://get.daocloud.io/docker | sh

# Docker中安装nginx


查看git的配置列表
我们可以先查看一下git的配置列表：
git config --global credential.helper store
git config --list

如果没有配置东西，应该是空的。照着下面配置完成后，你可以再试一下该命令，就会出现一系列配置信息。



2、进行配置
（1）命令行配置
git config --global user.name "username"
git config --global user.email "email"


有时git库里的东西比较多，我们只希望像SVN一样，只拉取git库的一个目录。
例如：基础代码仓库infra-code_ops有很多基础代码，我们只想拉取仓库里nginx-conf目录的文件。
$ git init infra-code_ops-nginx && cd  infra-code_ops-nginx          //初始化仓库,并进入该目录
$ git remote add -f origin http://gitlab.xxx.com/ops/infra-code_ops.git   //添加远程仓库地址
$ git config core.sparsecheckout true    //开启sparse checkout功能
$ echo "nginx-conf/" >> .git/info/sparse-checkout   //将nginx-conf/目录写入到该文件中
$ cat .git/info/sparse-checkout   //确认查看该文件内容
$ git pull origin master    //拉取远程master分支