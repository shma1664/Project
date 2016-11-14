#### Java性能调优概述

##### 性能调优步骤
* 设计调优
* 代码调优
* JVM调优
* 数据库调优
* 操作系统调优

```java
@Override
public Double getValue(Double value1, Double value2) {
    if(value2 == 0) {
        return -1d;
    }
    
    return value1 / value2;
}
```