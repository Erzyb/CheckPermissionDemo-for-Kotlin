# CheckPermissionDemo-for-Kotlin
kotlin学习
1.androidstudio中使用kotlin
1.1 导入Kotlin Plugins
1.2 code->Convert Java File to Kotlin File java代码转化kotlin代码
1.3 Tools->Kotlin-> Configure Kotlin in Project
2
2.1     abstract  class BaseActivity : AppCompatActivity()  //类继承，abstract关键字和java一样，抽象类，类中有抽象方法。
2.2   abstract fun initActivity()//抽象方法
2.3     open fun checkPermission(): Boolean//open关键字代表这个方法可以被子类复写，kotlin中方法如果需要被子类复写，必须用open标注，子类复写时必须用override标注，冒号后为返回值，抽象方法默认open
2.4    override fun checkPermission(): Boolean
2.5   object CheckPermissionUtil  //object 类似于java中static标注，静态方法工具类可以直接用object修饰，可以在使用时直接用类名.(方法名/属性) 
kotlin中没有static类型的fun,可以用Companion Objects，使用Companion Objects包裹体内的方法可以使用类似于java静态方法调用的方式调用。
2.6   kotlin 里的变量定义有两种，val 和 var。其中 val 等同 Java 中 final 修饰的变量（只读）。kotlin 的变量定义支持 赋值时类型推断，且 所有变量默认被修饰为不可为 null，必须显式在类型后添加 ? 修饰符才可赋值为 null。
2.7 集合.filter:Returns a list containing only elements matching the given 
2.8 集合.none：Returns `true` if no elements match the give
