package exercises.ex6

import scala.util.{Success, Try}

/*
Повторим условие еще раз (все перечисленное ниже уже прописано в системе):

нам доступно значение хоста (host) и порт (port)
есть сервер, который дает доступ к HTML странице
вам доступен метод render(page), выводящий содержимое страницы на экран
для доступа к HTML странице по заданному url в классе Connection описан метод get(url: String).
Если действие успехом не увенчалось, выбрасывается исключение, сообщающее о том, что Your Connection was Interrupted
сам процесс соединения с сервером описан в объекте HttpService, в методе apply (вот только сама имплементация от вас скрыта)
на вход apply подается host и port
если подключиться к серверу не удалось, срабатывает исключение с сообщением Someone else took the port


Ваша цель: воспользовавшись доступным функционалом, установить соединение с сервером и получить HTML страницу,
содержимое которой следует вывести на экран. Главное здесь - разобраться с возможными исключениями.


Примечание:

как реализовать(через цепочку вызовов, for-выражение или обычные последовательные вызовы) - решать вам
учтите, в ситуации, когда не удалось получить страницу или установить соединение, на экран просто ничего не должно выводиться
url можете указывать любое, мы решили слишком не усложнять задание, хотя в идеале следовало бы ограничить допустимые значения
импорт для Try уже сделан
не надо прописывать object Main extends App и подобное - все сделано за вас, сразу приступайте к написанию кода
мы не бросаем исключения, только ловим их
 */
object ex6_2 extends App {
    class Connection {
        def get(url:String):String = {
            if (!url.isEmpty)
                "HTML page"
            else
                throw new RuntimeException("Your Connection was Interrupted")
        }
    }

    class HttpService {
        def apply(host:String, port:String): Connection = {
            if (!port.isEmpty) {
                new Connection
            } else {
                throw new RuntimeException("Someone else took the port")
            }
        }
    }

    object HttpService extends HttpService;

    def render(page:String): Unit = {
        println(page)
    }


    def safeRender(host: String, port: String, url:String): Unit = {
        Try(HttpService.apply(host,port).get("mail.ru")).foreach(render)
    }

    safeRender("host","111","some_url")
    safeRender("host","","some_url")
    safeRender("host","111","")


}
