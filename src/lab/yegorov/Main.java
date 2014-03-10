package lab.yegorov;


import lab.control.Handle;
/**
 * Created by AdminPC on 20.02.14.
 */
/*
1.	Написать программу, которая создает минимум два подпроцесса (допускается больше двух), один из которых — управляющий,
 второй — вычислительный. Подпроцессы должны иметь доступ к общим разделяемым данным.
 Вычислительный подпроцесс выполняет вычисления по номеру варианта над разделяемыми данными.
 Управляющий подпроцесс передает данные  вычислительному подпроцессу, выводит результат вычислений,
 а также может приостановить работу вычислительного подпроцесса.
2.	Подпроцессы должны уведомлять друг друга о готовности очередной порции данных с помощью wait() и notify().
Синхронизировать подпроцессы таким образом, чтобы тесты, которые проверяют была ли выполнена такая синхронизация,
считались не пройденными при отсутствии вызова wait().
3.	Синхронизировать доступ к общим данным таким образом,
чтобы тесты, которые проверяют была ли выполнена такая синхронизация,
считались не пройденными при отсутствии ключевого слова synchronized.
4.	Все классы описать внутри отдельного пакета.


Проверка года на високосность

 */
public class Main {
    public static void main(String args[]) {

        Thread handle = new Thread(new Handle());
        handle.start();
        try {
            handle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
