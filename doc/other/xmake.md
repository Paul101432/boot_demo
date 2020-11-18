[TOC]

## 1.xmake使用背景

+ 使用C++编写和xcode编译，达到跨平台，实现一次编写，随处构建

| 开发工具            | 编译平台                                |
| ------------------- | --------------------------------------- |
| visual  studio 2015 | windows                                 |
| xcode               | MacOs                                   |
| gcc交叉编译         | Linux                                   |
| xmake               | Windows，MacOs,Linux，Android，iPhoneOS |

+ 它默认不会去生成IDE相关的工程文件，采用直接编译，并且更加的方便易用

## 2.[xmake](https://xmake.io/#/zh/?id=windows)的安装

+ window下安装 Release
+ 运行安装程序 xmake-[version].exe


## 3 基本使用

### 3.1创建工程

| 项目类型   | 命令                                |
| ---------- | ----------------------------------- |
| 动态库项目 | xmake create -l c++ -t shared hello |
| 静态库项目 | xmake create -l c++ -P ./hello      |
| 控制台项目 | xmake create -l c++ -P ./hello      |

### 3.2构建工程

```
# 构建编译工程
xmake
# 重新编译，加上-v则看到详细编译过程
xmake -r
```

### 3.3运行程序

```
# 运行名为hello的可执行文件
xmake run hello
```

### 3.4打包所有平台

```
# 加m编译所有平台
xmake p
or xmake m  package
```

### 3.5安装到当前目录

```
xmake i
or xmake install
```

### 3.6生成vs2015项目文件

```
# 另外xmake.lua里面需要加上 add_rules("mode.debug", "mode.release")
xmake project -k vs2015 -m "debug,release"
```
### 3.7修改目标平台

```
# 清除配置，修改目标平台为默认，当前平台
xmake f -c
# 重新编译加载配置
xmake
```

+ 设置平台,然后重新编译,`-c`强制重新检测,清掉之前检测的配置缓存
```
xmake f -p 平台 -a 架构 
# Compile for the given architecture. (default: auto)
- android: armv5te armv6 armv7-a armv8-a arm64-v8a
- iphoneos: armv7 armv7s arm64 i386 x86_64
- linux: i386 x86_64
- macosx: i386 x86_64
- mingw: i386 x86_64
- watchos: armv7k i386
- windows: x86 x64 amd64 x86_amd64
```
| 平台      | 命令             |备注 |
| --------- | ---------------- |---------------- |
| Windows  | xmake f -p windows -a x86 |需要vs或者cygwin等|
| MacOSX   | xmake f -p macosx |需要xcode工具链|
| mingw | xmake f -p mingw -c |需要安装mingw-w64或者mingw|
| Linux | 待补充  |
| Android | xmake f -p android --sdk="/Users/jl/android-ndk-r16b" |需要ndk环境
| iPhoneOS |xmake f -p iphoneos |需要xcode工具链

+ ndk[下载网址](https://developer.android.google.cn/ndk/downloads/)
+ [mac上安装mingw-w64](https://brewinstall.org/Install-mingw-w64-on-Mac-with-Brew/)

### 3.8Mac上使用mingw编译

- 编译mingw生成的exe不依赖gcc动态库

```
add_ldflags("-static", {force = true})
```

eg实例

```
# 创建动态库项目
xmake create -l c++ -t shared hello
# 设置编译平台为mingw  (加-c强制重新检测，清掉之前检测的配置缓存)
xmake f -p mingw -c
# 编译  (加上-v查看详细信息)
xmake -r -v
```

+ 遇到报错`error: cc1plus: 对不起，尚未实现：未编译入对 64 位模式的支持`,就切换分支

```
# 加-v查看详细的日志
xmake update -v dev
```

+ 默认mingw 平台是x86_64

## 4 常用接口及其示例

| 接口            | 描述                                    | 示例                           |
| --------------- | --------------------------------------- | ------------------------------ |
| set_kind        | 设置目标编译类型,如链接库,静态库,控制台 | set_kind("shared")             |
| is_plat         | 判断当前平台                            | is_plat("windows")             |
| target          | 定义工程目标                            | target("山地驱动")             |
| add_includedirs | 添加头文件搜索目录                      | add_includedirs("include")     |
| add_linkdirs    | 添加链接库搜索目录                      | add_linkdirs("libs/windows")   |
| add_links       | 添加链接库                              | add_links("FT_ID03003")        |
| add_deps        | 添加工程依赖                            | add_deps("sdUkey")             |
| add_ldflags     | 添加链接选项                            | add_ldflags("-static")         |
| add_files       | 添加源代码文件                          | add_files("sdSocket/main.cpp") |

- 添加链接库出错可以试试，libcrypto.lib要重命名为.a后缀然后add_links("crypto")
- 添加目录是以xmake.lua文件所在位置为根目录
- 相应可以在[sdSocketKey_mac_win](http://192.168.2.100:88/main/sd-cpp/blob/master/sdSocketkey_mac_win/xmake.lua)项目的xmake.lua查看理解

## 5.[使用手册](https://xmake.io/#/zh/manual)及常用设置

### 5.1使用xmake进行vs对应的设置

+ C/C++等设置，在其命令行中找到对应匹配的选项 

  | vs设置 属性 | xmake对应编译选项 |
  | ----------- | ----------------- |
  | C/C++       | add_cxflags()     |
  | 链接器      | add_ldflags()     |

### 5.2常用设置

+ 设置适配XP

```
--适配XP 设置平台集+系统最低版本
add_defines("_USING_V110_SDK71_")
--添加链接选项
add_ldflags("/SUBSYSTEM:CONSOLE,5.01")
```

+ 隐藏控制台

```
add_ldflags("/SUBSYSTEM:WINDOWS", {force = true})
add_ldflags("/ENTRY:mainCRTStartup", {force = true})
```

+ 添加图标

```
-- 添加rc文件即可
add_files("icon.rc")
```

## 6.遇到的bug

+ vs编译不会遇到，xmake编译则需要设置

```
error C1041: 无法打开程序数据库“xxx\vc140.pdb”；如果要将多个 CL.EXE 写入同一个 .PDB 文件
```

+ 解决：添加编译设置

```
add_cxflags("/Z7","/GF")
add_ldflags("/DEBUG")
```

## 7.其他命令 

### 7.1方便的多目标依赖

+ add_deps()

```
target("test")
    set_kind("static")
    add_files("src/test/*.c")

target("hello")
    add_deps("test")  --添加依赖
    set_kind("binary")
    add_files("src/hello/*.c")

```

### 7.2预编译头文件支持

+ set_pcxxheader()

```
target("test")
    -- ...
    set_pcxxheader("header.h")
```

### 7.3查找依赖包

+ find_*

```
target("test")
    set_kind("binary")
    add_files("*.c")
    on_load(function (target)
        import("lib.detect.find_package")
        target:add(find_package("zlib"))
    end)
```
### 7.4编译的时候手动切换编译类型

+ xmake f -k 类型,xmake
```
# 编译静态库
$ xmake f -k static
$ xmake
# 编译动态库
$ xmake f -k shared
$ xmake
```
