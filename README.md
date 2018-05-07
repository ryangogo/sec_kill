记录一下相关的技术要点
1.在SuccessKilledMapper.xml中
<insert id="insert" parameterType="com.seckill.pojo.SuccessKilled" >
    <!--主键冲突，报错-->
    insert ignore into success_killed (seckill_id, user_phone)
    values (#{seckillId,jdbcType=BIGINT}, #{userPhone,jdbcType=BIGINT})
</insert>
上面的sql，（seckill_id，user_phone）这两个字段是双主键，这种写法可以防止一个用户访问两次，因为用户访问的时候这两个字段的
的属性一定是重复的。
在insert后面接了一个“ignore”这种写法可以防止sql因为有人访问两次报错，且该sql的返回值为0.（插入的新数据为0条）。

2.作为秒杀系统，接口的url应该在时间到了的时候由系统输出该url而不是固定的url，这样可以防止接口被非法获取。