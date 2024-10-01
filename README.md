# Lamda Expressions

Лямбда выражения были добавлены в Java 8. Их основная цель – повысить читабельность и уменьшить количество кода.
Но, прежде чем перейти к лямбдам, нам необходимо понимать функциональные интерфейсы.

## Что же такое функциональный интерфейс?
**Если интерфейс в Java содержит один и только один абстрактный метод, то он называется функциональным.** Этот 
единственный метод определяет назначение интерфейса.

Например, интерфейс `Runnable` из пакета `java.lang` является функциональным, потому, что он 
содержит только один метод `run()`.

**Пример 1: объявление функционального интерфейса в java**
```java

import java.lang.FunctionalInterface;

@FunctionalInterface
public interface MyInterface { 
// один абстрактный метод
	double getValue();
}

```
В приведенном выше примере, интерфейс `MyInterface` имеет только один абстрактный метод `getValue()`. Значит, этот 
интерфейс — функциональный.

В Java 7, функциональные интерфейсы рассматривались как Single Abstract Methods (SAM). SAM 
обычно реализовывались с помощью анонимных классов.

**Пример 2: реализация SAM с помощью анонимного класса в java**

```java

public class FunctionInterfaceTest {  
    public static void main(String[] args) {  
  
        // анонимный класс  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                System.out.println("Я только что реализовал функциональный интерфейс Runnable.");  
            }  
        }).start();  
    }  
}
```

**Результат выполнения:**

```
Я только что реализовал функциональный интерфейс Runnable.
```

Java 8 расширила возможности SAM, сделав шаг вперед. Как мы знаем, функциональный интерфейс 
содержит только один метод, следовательно, нам не нужно указывать название метода при передаче
его в качестве аргумента. Именно это и позволяет нам lambda-выражения.

## Введение в лямбда-выражения

Лямбда-выражения, по сути, это анонимный класс или метод. Лямбда-выражение не выполняется 
само по себе. Вместо этого, оно используется для реализации метода, определенного в 
функциональном интерфейсе.

### Как записать лямбда-выражение в Java?
В Java, лямбда-выражения имеют следующий синтаксис:

```
(parameter list) -> lambda body
```

Здесь мы использовали новый оператор `(->)` — лямбда-оператор.

**Примеры:**
Предположим, у нас есть такой метод:

```java

double getPiValue() {  
    return 3.1415;  
}

```

Мы можем записать его, используя лямбда, как:

```
() -> 3.1415
```

Этот метод не имеет никаких параметров. Следовательно, левая часть выражения содержит пустые скобки. 
Правая сторона – тело лямбда-выражения, которое определяет его действие. В нашем случае, возвращается значение 3.1415.

### Типы лямбда-выражений
В Java, тело лямбды может быть двух типов.

**1. Однострочные**
```java 

() -> System.out.println("Lambdas are great");

```

**2. Блочные (многострочные)**
```java

() -> {  
    double pi = 3.1415;  
    return pi;  
};

```

Этот тип позволяет лямбда-выражению иметь несколько операций внутри себя. Эти операции должны быть помещены в фигурные 
скобки, после которых необходимо ставить точку с запятой.

**Примечание:** многострочные лямбда-выражения, всегда должны иметь оператор `return`, в отличии от однострочных.

**Пример 3: лямбда-выражение**

Напишем Java программу, которая бы возвращала значение Pi, используя лямбда-выражение.

Как говорилось ранее, лямбда-выражение не выполняется само собой. Скорее, оно формирует реализацию абстрактного метода, объявленного в функциональном интерфейсе.

И так, для начала, нам необходимо описать функциональный интерфейс.

```java

import java.lang.FunctionalInterface;  
  
// функциональный интерфейс  
@FunctionalInterface  
interface MyInterface{  
  
    // абстрактный метод  
    double getPiValue();  
}  

public class Main {  
  
    public static void main( String[] args ) {  
  
        // объявление ссылки на MyInterface  
        MyInterface ref;  
  
        // лямбда-выражение  
        ref = () -> 3.1415;  
  
        System.out.println("Value of Pi = " + ref.getPiValue());  
    }  
}

```

**Результат выполнения:**
```
Value of Pi = 3.1415
```

**В примере выше:**
- Мы создали функциональный интерфейс MyInterface, который содержит один абстрактный метод` getPiValue().`
- Внутри класса Main, мы объявили ссылку на MyInterface. Обратите внимание, что мы можем объявить ссылку на интерфейс, 
но не можем создать его объект.

```java

// приведет к ошибке  
MyInterface ref = new myInterface();  
// это верно  
MyInterface ref;

```

- Затем мы присвоили ссылке лямда-выражение

```java

ref = () -> 3.1415;

```

- В заключении, мы вызвали метод `getPiValue()`, используя ссылку на интерфейс.

```java

System.out.println("Value of Pi = " + ref.getPiValue());

```

### Лямбда-выражения с параметрами
До этого момента, мы создавали лямбда-выражения без каких-либо параметров. Однако, как и методы, лямбды могут 
иметь параметры.

```java
(n) -> (n % 2) == 0
```

В этом примере, переменная n внутри скобок является параметром, переданном в лямбда-выражение. Тело лямбды принимает 
параметр и проверяет его на четность.

**Пример 4: использование лямбда-выражения с параметрами**
```java

@FunctionalInterface  
interface MyInterface {  
  
    // абстрактный метод  
    String reverse(String n);  
}  
  
public class Main {  
  
    public static void main( String[] args ) {  
  
        // объявление ссылки на MyInterface  
        // присвоение лямбда-выражения ссылке        
        MyInterface ref = (str) -> {  
  
            String result = "";  
            for (int i = str.length()-1; i >= 0 ; i--)  
                result += str.charAt(i);  
            return result;  
        };  
        // вызов метода из интерфейса  
        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));  
    }  
  
}

```

**Результат выполнения:**
```
Lambda reversed = adbmaL
```

### Параметризированный функциональный интерфейс
До этого момента, мы использовали функциональные интерфейсы, которые принимали только один тип значения. Например:

```java

@FunctionalInterface  
interface MyInterface {  
    String reverseString(String n);  
}

```

Вышеупомянутый функциональный интерфейс принимает только String и возвращает String. Однако, мы можем сделать наш 
интерфейс универсальным, чтобы использовать с любым типом данных.

**Пример 5: параметризированный интерфейс и лямбда-выражения**
```java

// Параметризированный интерфейс  
@FunctionalInterface  
interface GenericInterface<T> {  
  
    // параметризированный метод  
    T func(T t);  
}  
  
public class Main {  
  
    public static void main(String[] args) {  
  
        // Объявление ссылки на параметризированный интерфейс  
        // который принимает String        
        // и присвоение ей лямбды        
        GenericInterface<String> reverse = (str) -> {  
  
            String result = "";  
            for (int i = str.length() - 1; i >= 0; i--)  
                result += str.charAt(i);  
            return result;  
        };  
  
        System.out.println("Lambda reversed = " + reverse.func("Lambda"));  
  
        // Объявление ссылки на параметризированный интерфейс  
        // который принимает Integer        
        // и присвоение ей лямбды       
         GenericInterface<Integer> factorial = (n) -> {  
  
            int result = 1;  
            for (int i = 1; i <= n; i++)  
                result = i * result;  
            return result;  
        };  
  
        System.out.println("factorial of 5 = " + factorial.func(5));  
    }  
}
```

**Результат выполнения:**
```
Lambda reversed = adbmaL
factorial of 5 = 120
```
В этом примере, мы создали параметризированный функциональный интерфейс `GenericInterface`, который содержит 
параметризированный метод `func(). `

Затем, внутри класса Main:
- `GenericInterface<String> reverse` – создает ссылку на интерфейс, который работает со String.
- `GenericInterface<Integer> factorial` — создает ссылку на интерфейс, который работает с Integer.

### Структура Lambda-выражений
- Lambda-выражения могут иметь от 0 и более входных параметров.
- Тип параметров можно указывать явно либо может быть получен из контекста. Например (`int a`) можно записать и так (`a`)
- Параметры заключаются в круглые скобки и разделяются запятыми. Например (`a, b`) или (`int a, int b`) или (`String a`, `int b`, `float c`)
- Если параметров нет, то нужно использовать пустые круглые скобки. Например `() -> 42`
- Когда параметр один, если тип не указывается явно, скобки можно опустить. Пример: `a -> return a*a`
- Тело Lambda-выражения может содержать от 0 и более выражений.
- Если тело состоит из одного оператора, его можно не заключать в фигурные скобки, а возвращаемое значение можно указывать без ключевого слова `return`.
- В противном случае фигурные скобки обязательны (блок кода), а в конце надо указывать возвращаемое значение с использованием ключевого слова `return` (в противном случае типом возвращаемого значения будет `void`).

## Отличие Lambda-выражений от анонимных класcов
Главное отличие состоит в использовании ключевого слова `this`. Для анонимных классов ключевое слово `this` обозначает 
объект анонимного класса, в то время как в lambda-выражении `this` обозначает объект класса, в котором lambda-выражение 
используется. Другое их отличие заключается в способе компиляции. **Java компилирует lambda-выражения с преобразованием 
их в `private`-методы класса.** При этом используется инструкция **invokedynamic**, появившаяся в Java 7 для 
динамической привязки метода.

## Доступ к внешним переменным
Скомпилируется ли такой код с анонимным классом?
```java

int counter = 0;  
Runnable r = new Runnable() {  
    @Override  
    public void run() {  
        counter++;  
    }  
};

```
Нет. Переменная `counter` должна быть `final`. Или не обязательно `final`, но в любом случае изменять свое значение она
не может. Тот же принцип используется и в лямбда-выражениях. Они имеют доступ ко всем переменным, которые им «видны» из
того места, где они объявлены. Но лямбда не должна их изменять (присваивать новое значение). Правда, есть вариант обхода 
этого ограничения в анонимных классах. Достаточно лишь создать переменную ссылочного типа и менять внутреннее состояние
объекта. При этом сама переменная будет указывать на тот же объект, и в таком случае можно смело указывать 
её как `final`.

```java

final AtomicInteger counter = new AtomicInteger(0);  
Runnable r = new Runnable() {  
    @Override  
    public void run() {  
        counter.incrementAndGet();  
    }  
};

```
Здесь у нас переменная `counter` является ссылкой на объект типа `AtomicInteger`. А для изменения состояния этого 
объекта используется метод `incrementAndGet()`. Значение самой переменной во время работы программы не меняется и всегда 
указывает на один и тот же объект, что позволяет нам объявить переменную сразу с ключевым словом `final`.

Это касается и вызова методов. Изнутри лямбда-выражения можно не только обращаться ко всем «видимым» переменным, но и 
вызывать те методы, к которым есть доступ.

```java

public class Main {  
    public static void main(String[] args) {  
        Runnable runnable = () -> staticMethod();  
        new Thread(runnable).start();  
    }  
  
    private static void staticMethod() {  
        System.out.println("Я - метод staticMethod(), и меня только-что кто-то вызвал!");  
    }  
}
```
Хотя метод `staticMethod()` и приватный, но он «доступен» для вызова внутри метода `main()`, поэтому точно так же 
доступен для вызова изнутри лямбды, которая создана в методе `main`.

## Момент выполнения кода лямбда-выражения
Когда выполнится код внутри лямбда-выражения? В момент создания? Или же в тот момент, когда (еще и неизвестно где) оно 
будет вызвано? Проверить довольно просто.
```java

System.out.println("Запуск программы");  
  
// много всякого разного кода  
// ...  
  
System.out.println("Перед объявлением лямбды");  
  
Runnable runnable = () -> System.out.println("Я - лямбда!");  
  
System.out.println("После объявления лямбды");  
  
// много всякого другого кода  
// ...  
  
System.out.println("Перед передачей лямбды в тред");  
new Thread(runnable).start();

```

Вывод на экран:
```
Запуск программы  
Перед объявлением лямбды  
После объявления лямбды  
Перед передачей лямбды в тред  
Я - лямбда!
```
Видно, что код лямбда-выражения выполнился в самом конце, после того, как был создан тред и лишь когда процесс 
выполнения программы дошел до фактического выполнения метода `run()`. А вовсе не в момент его объявления. Объявив 
лямбда-выражение, мы лишь создали объект типа `Runnable` и описали поведение его метода `run()`. Сам же метод был 
запущен значительно позже.

## Method References (Ссылки на методы)?
Допустим, у нас есть лямбда-выражение, которое не делает ничего особенного, а просто вызывает какой-то метод.
```java

x -> System.out.println(x)
```

Ему передали некий `х`, а оно — просто вызвало `System.out.println()` и передало туда `х`. В таком случае, мы можем 
заменить его на ссылку на нужный нам метод. Вот так:
```java

System.out::println
```

Более полный пример:

```java

List<String> strings = new LinkedList<>();  
strings.add("мама");  
strings.add("мыла");  
strings.add("раму");  
  
strings.forEach(System.out::println);
```
Главное, чтобы совпадали принимаемые параметры методов `(println()` и `accept())`. Поскольку метод `println()` может 
принимать что угодно (он перегружен для всех примитивов и для любых объектов, мы можем вместо лямбда-выражения передать 
в `forEach()` просто ссылку на метод `println()`. Тогда `forEach()` будет брать каждый элемент коллекции и передавать 
его напрямую в метод `println()`. Кто сталкивается с этим впервые, обратите внимание, что мы не вызываем метод 
`System.out.println()` (с точками между словами и со скобочками в конце), а именно передаем саму ссылку на этот метод

### Синтаксис использования Method References
Он довольно прост:
1. Передаем ссылку на статический метод `ИмяКласса::имяСтатическогоМетода`

```java

public class Main {  
    public static void main(String[] args) {  
        List<String> strings = new LinkedList<>();  
        strings.add("мама");  
        strings.add("мыла");  
        strings.add("раму");  
  
        strings.forEach(Main::staticMethod);  
    }  
  
    private static void staticMethod(String s) {  
        // do something  
    }  
}
```

2. Передаем ссылку на не статический метод используя существующий объект `имяПеременнойСОбъектом::имяМетода`
```java

public class Main {  
    public static void main(String[] args) {  
        List<String> strings = new LinkedList<>();  
        strings.add("мама");  
        strings.add("мыла");  
        strings.add("раму");  
  
        Main instance = new Main();  
        strings.forEach(instance::nonStaticMethod);  
    }  
  
    private void nonStaticMethod(String s) {  
        // do something  
    }  
}
```

3. Передаем ссылку на не статический метод используя класс, в котором реализован такой метод `ИмяКласса::имяМетода`
```java

public class Main {  
    public static void main(String[] args) {  
        List<User> users = new LinkedList<>();  
        users.add(new User("Вася"));  
        users.add(new User("Коля"));  
        users.add(new User("Петя"));  
  
        users.forEach(User::print);  
    }  
  
    private static class User {  
        private String name;  
  
        private User(String name) {  
            this.name = name;  
        }  
  
        private void print() {  
            System.out.println(name);  
        }  
    }  
}
```

4. Передаем ссылку на конструктор `ИмяКласса::new`  
Использование ссылок на методы очень удобно, когда есть готовый метод , который вас полностью устраивает, и вы бы 
хотели использовать его в качестве callback-а. В таком случае, вместо того чтобы писать лямбда-выражение с кодом того 
метода, или же лямбда-выражение, где мы просто вызываем этот метод, мы просто передаем ссылку на него. И всё.

## Ссылки на метод как параметры методов
Java можно в качестве параметра в метод передавать ссылку на другой метод. В принципе данный способ аналогичен передаче 
в метод лямбда-выражения.

Ссылка на метод передается в виде `имя_класса::имя_статического_метода` (если метод статический) 
или `объект_класса::имя_метода` (если метод нестатический). Рассмотрим на примере:
```java

// функциональный интерфейс  
interface Expression{  
    boolean isEqual(int n);  
}  
// класс, в котором определены методы  
class ExpressionHelper{  
  
    static boolean isEven(int n){  
  
        return n%2 == 0;  
    }  
  
    static boolean isPositive(int n){  
  
        return n > 0;  
    }  
}  
public class LambdaApp {  
  
    public static void main(String[] args) {  
  
        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};  
        System.out.println(sum(nums, ExpressionHelper::isEven));  
  
        Expression expr = ExpressionHelper::isPositive;  
        System.out.println(sum(nums, expr));  
    }  
  
    private static int sum (int[] numbers, Expression func)  
    {  
        int result = 0;  
        for(int i : numbers)  
        {  
            if (func.isEqual(i))  
                result += i;  
        }  
        return result;  
    }  
}
```

Здесь также определен функциональный интерфейс Expression, который имеет один метод. Кроме того, определен класс 
ExpressionHelper, который содержит два статических метода. В принципе их можно было определить и в основном классе 
программы, но я вынес их в отдельный класс.

В основном классе программы LambdaApp определен метод `sum()`, который возвращает сумму элементов массива, 
соответствующих некоторому условию. Условие передается в виде объекта функционального интерфейса Expression.

В методе `main` два раза вызываем метод `sum`, передавая в него один и тот же массив чисел, но разные условия. 
Первый вызов метода `sum`:

`System.out.println(sum(nums, ExpressionHelper::isEven));`

На место второго параметра передается `ExpressionHelper::isEven`, то есть ссылка на статический метод `isEven()` класса 
ExpressionHelper. При этом методы, на которые идет ссылка, должны совпадать по параметрам и результату с методом 
функционального интерфейса.

При втором вызове метода `sum` отдельно создается объект Expression, который затем передается в метод:
```java

Expression expr = ExpressionHelper::isPositive;  
System.out.println(sum(nums, expr));
```
Использование ссылок на методы в качестве параметров аналогично использованию лямбда-выражений.

## Ссылки на конструкторы

Подобным образом мы можем использовать конструкторы: `название_класса::new`. Например:

```java

public class LambdaApp {  
  
    public static void main(String[] args) {  
  
        UserBuilder userBuilder = User::new;  
        User user = userBuilder.create("Tom");  
        System.out.println(user.getName());  
    }  
}  
interface UserBuilder{  
    User create(String name);  
}  
  
class User{  
  
    private String name;  
    String getName(){  
        return name;  
    }  
  
    User(String n){  
        this.name=n;  
    }  
}
```

При использовании конструкторов методы функциональных интерфейсов должны принимать тот же список параметров, что и 
конструкторы класса, и должны возвращать объект данного класса.

## Лямбды как результат методов
Также метод в Java может возвращать лямбда-выражение. Рассмотрим следующий пример:
```java

interface Operation{  
    int execute(int x, int y);  
}  
  
public class LambdaApp {  
  
    public static void main(String[] args) {  
  
        Operation func = action(1);  
        int a = func.execute(6, 5);  
        System.out.println(a);          // 11  
  
        int b = action(2).execute(8, 2);  
        System.out.println(b);          // 6  
    }  
  
    private static Operation action(int number){  
        switch(number){  
            case 1: return (x, y) -> x + y;  
            case 2: return (x, y) -> x - y;  
            case 3: return (x, y) -> x * y;  
            default: return (x,y) -> 0;  
        }  
    }  
}
```
В данном случае определен функциональный интерфейс Operation, в котором метод execute принимает два значения типа int 
и возвращает значение типа int.

Метод action принимает в качестве параметра число и в зависимости от его значения возвращает то или иное 
лямбда-выражение. Оно может представлять либо сложение, либо вычитание, либо умножение, либо просто возвращает 0. Стоит
учитывать, что формально возвращаемым типом метода action является интерфейс Operation, а возвращаемое лямбда-выражение 
должно соответствовать этому интерфейсу.

В методе main мы можем вызвать этот метод action. Например, сначала получить его результат - лямбда-выражение, которое 
присваивается переменной Operation. А затем через метод execute выполнить это лямбда-выражение:
```java

Operation func = action(1);  
int a = func.execute(6, 5);  
System.out.println(a);
```

Либо можно сразу получить и тут же выполнить лямбда-выражение:

```java

int b = action(2).execute(8, 2);  
System.out.println(b);          // 6
```

## Встроенные функциональные интерфейсы
В Java имеется некоторое количество встроенных функциональных интерфейсов. В частности они широко используются 
в Stream API.

- `Predicate<T>`
- `Consumer<T>`
- `Function<T,R>`
- `Supplier<T>`
- `UnaryOperator<T>`
- `BinaryOperator<T>`

### Predicate\<T>

```java
public interface Predicate<T> {
	public boolean test(T t);
}
```

Этот функциональный интерфейс используется для проверки соблюдения некоторого условия. Если условие соблюдается - 
возвращается `true`, в противном случае `false`

**Пример:**
1. Класс с методом для фильтрации [StudentFilter.java](src/main/java/_2_predicate/StudentFilter.java)
2. Класс, описывающий студентов [Student.java](src/main/java/_2_predicate/Student.java)
3. Тестирование метода фильтрации [PredicateExample.java](src/main/java/_2_predicate/PredicateExample.java)
4. Пример использования интерфейса Predicate в методах коллекций [RemoveIfExample.java](src/main/java/_2_predicate/RemoveIfExample.java)

### BinaryOperator\<T>
Метод интерфейса принимает в качестве параметра два объекта типа `T` и выполняет над ними бинарную операцию и возвращает 
ее результат также в виде объекта типа `T`
```java

public interface BinaryOperator<T>{
	T apply(T t1, T t2);
}
```
**Пример** - [BinaryOperatorExample.java](src/main/java/_6_binaryoperator/BinaryOperatorExample.java)

### UnaryOperator\<T>
Принимает в качестве параметра объект типа `T` и выполняет над ними операции и возвращает результат операций в 
виде объекта `T`
```java
public interface UnaryOperator<T>{
	T apply(T t);
}
```

**Пример** - [UnaryOperatorExample.java](src/main/java/_7_unaryoperator/UnaryOperatorExample.java)

### Function\<T,R>
Представляет функцию перехода от объекта типа `T` к объекту типа `R`
```java
public interface Function<T,R>{
	R apply(T t);
}
```

**Пример:**
1. реализация метода с использованием интерфейса Function<T,R> - [StudentInfo.java](src/main/java/_5_function/StudentInfo.java)
2. класс описывающий студентов - [Student.java](src/main/java/_5_function/Student.java)
3. класс для теста - [FunctionExample.java](src/main/java/_5_function/FunctionExample.java)

### Consumer\<T>
Выполняет некоторое действие над объектом типа `T`, при этом ничего не возвращая
```java
public interface Consumer<T>{
	void accept(T t);
}
```


### Supplier\<T>
Не принимает никаких аргументов, но должен возвращать объект типа `T`
```java
public interface Supplier<T>{
	T get();
}
```


**Пример:**
1. реализация интерфейсов Consumer и Supplier - [CarConstructor.java](src/main/java/_4_consumer/CarConstructor.java)
2. класс [Car.java](src/main/java/_4_consumer/Car.java)
3. тестирование - [ConsumerExample.java](src/main/java/_4_consumer/ConsumerExample.java)
4. Использование Consumer в методах коллекций - [ForEachExample.java](src/main/java/_4_consumer/ForEachExample.java)



