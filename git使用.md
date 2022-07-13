<!-- vscode-markdown-toc -->
* 1. [1.git常用命令](#git)
	* 1.1. [1.1 设置用户签名](#)
	* 1.2. [1.2 初始化本地库](#-1)
	* 1.3. [1.4 查看本地库状态](#-1)
	* 1.4. [1.5 添加暂存区](#-1)
	* 1.5. [1.6提交本地库](#-1)
	* 1.6. [1.7历史版本](#-1)
* 2. [2.git分支](#git-1)
	* 2.1. [2.1 查看分支](#-1)
	* 2.2. [2.2 创建分支](#-1)
	* 2.3. [2.3 切换分支](#-1)
	* 2.4. [2.4 合并分支](#-1)
* 3. [3.github操作](#github)
* 4. [4.IDEA集成GIT](#IDEAGIT)
	* 4.1. [1.配置git忽略文件](#git-1)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->##  1. <a name='git'></a>1.git常用命令
###  1.1. <a name=''></a>1.1 设置用户签名
1. 基本用法 
    git config --global user.name 用户名
    git config --global user.email 邮箱
//  cat ~/.gitconfig 查看配置信息
说明：签名是区分不同操作者，**这里设置的用户签名和将来登录github没有任何关系**
###  1.2. <a name='-1'></a>1.2 初始化本地库
1. 基本用法
    git init
说明：初始化效果是产生.git文件
###  1.3. <a name='-1'></a>1.4 查看本地库状态
1. 基本用法
    git status

###  1.4. <a name='-1'></a>1.5 添加暂存区
1. 基本用法
   git add 文件名

###  1.5. <a name='-1'></a>1.6提交本地库
1. 基本用法
   git commit -m "日志信息" 文件名

###  1.6. <a name='-1'></a>1.7历史版本
1. 查看历史信息
   命令：
   git reflog 查看版本信息
   git log    查看详细信息

2. 版本穿梭
   命令：
   git reset -hard 版本号

##  2. <a name='git-1'></a>2.git分支
###  2.1. <a name='-1'></a>2.1 查看分支
1. 基本用法
   git branch -v
###  2.2. <a name='-1'></a>2.2 创建分支
1. 基本用法
   git branch 分支名
###  2.3. <a name='-1'></a>2.3 切换分支
1. 基本用法
   git checkout 分支名
###  2.4. <a name='-1'></a>2.4 合并分支
1. 基本用法
    git merge 分支名

2. 站在master分支上合并其他分支
```c
    git checkout master //切换到master分支
    git merge otherbranch //合并其他分支
```


3. 产生冲突
   
产生冲突时 ，查看状态，然后打开文件修改

4. 解决冲突
   
编辑有冲突的文件，删除特殊文件，决定要使用的内容。然后添加到暂存区。

注意提交时：git commit 命令不能带文件名。

##  3. <a name='github'></a>3.github操作
1. 创建远程库
2. 创建远程仓库别名
   git remote -v 查看当前所有远程地址别名
   git remote add 别名 远程地址 起别名
   git push 别名 分支  推送本地分支上的内容到远程仓库
   git clone 远程地址  将远程仓库的内容克隆到本地
   git pull  远程地址别名 远程分支名 将远程仓库对于分支最新内容拉下来后与当前本地分支直接合并
+   git remote -v
+   git remote add 别名 远程地址
3. 推送本地分支到远程仓库
+ git push 别名 分支
  
4. 克隆远程仓库到本地
   git clone 远程地址
5. 拉取远程库内容
   git pull 远程库地址别名 远程分支名
6. SSH免密登录
rm -rvf .ssh 删除.ssh
ssh-keygen -t rsa -C 邮箱名
cat id_rsa.pub 
复制id_rsa.pub文件内容，登录github，点击用户头像，->settings->SSH and GPG keys
配置SSH，这样再往远程仓库中push东西时，使用SSH就不需要登录了

##  4. <a name='IDEAGIT'></a>4.IDEA集成GIT
###  4.1. <a name='git-1'></a>1.配置git忽略文件
1）创建忽略文件git.ignore，为了便于让~/.gitconfig文件引用，建议放在用户目录下。

git.ignore 文件模板内容如下：
```
# Compiled class file
*.class
# Log file
*.log
# BlueJ files
*.ctxt
# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar
# virtual machine crash logs, see
http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

.classpath
.project
.settings
target
.idea
*.iml
```
2)在git.gitconfig文件中引用忽略配置文件
```
[user]
    name = Layne
    email = Layne @atguigu.com
[core]
    excludesfile = C:/Users/ asus git .ignore
    注意：这里要使用“正斜线（/）”，不要使用“反斜线(\)"
```
## 5.其他
刚开始建立一个git库时无法推送上去，可能原因，原来库中有文件。导致无法合成。
解决方法:可以是使用一下命令
```
   git pull 别名 分支 --allowed-unrelated-histories //强制合成
   然后再次推送
```