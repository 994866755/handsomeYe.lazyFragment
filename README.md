使用Fragment进行懒加载
======================



使用方法
----------

1. 定义3个布尔值参数

```
    private boolean isFristShowFragment = true;
    private boolean isVisibleToUser;
    private boolean isInitView = false;
```

2. 重写setUserVisibleHint方法

```
 @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        Log.v("lazy","setUserVisibleHint  " + isVisibleToUser);
        if (isFristShowFragment && isVisibleToUser && isInitView){
            // todo 这里做懒加载的操作
        }
    }
```

主要是判断和里面的方法

3. 在你进行初始化页面的地方或者设置数据的地方加一层判断

```
if (isFristShowFragment && isVisibleToUser) {
            setDataToView();
        }
```

4. 在初始化后设置isInitView和isFristShowFragment为true



说明文档
--------------------
http://www.jianshu.com/p/2836cd840afa

