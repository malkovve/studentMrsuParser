# Работа с XML

**Цель работы:** научится читать и использовать содержимое XML-файлов,

## Представление данных в программе

Нужно создать класс **Client** для хранения информации о клиенте. Пример класса:
```
public struct Client {
    id;              // идентификатор
    name;            // ФИО
    personnelNumber; // персональный номер
    address;         // адресс проживания
} 
```
класс **Address** для хранения адреса проживания клиента. Пример:

```
public struct Address {
    id;           // идентификатор
    city;         // город
    street;       // улица
    house;        // дом
    floor;        // этаж
    flatNumber;   // квартира
} 
```


## Парсинг xml-файла

Для парсинга xml- файла предлагается использовать в качестве примера следующий код:

```
        List<Address> addressList = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            
        } catch (XMLStreamException ex) {
            
        }
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("item")) {
                        Заполнить объект Address/Client и сохранить его в 
                        соответствующую структуру, приводя поля к соответствующим типам
                    }
                }
            }
        } catch (XMLStreamException ex) {
            
        }
```

## Алгоритм выполнения работы

Для выполнения работы необходимо:

1. Выполнить *fork* репозитария в свой аккаунт.
1. Выполнить клонирование репозитария из своего аккаунта к себе на локальную машину (`git clone`).
1. Создать ветку **git** с индивидуальным номером (`git branch имя_ветки`).
1. Сделать ветку активной (`git checkout имя`).
1. Добавить файлы в хранилище (`git add`).
1. Выполнить фиксацию изменений (`git commit -m "комментарий"`).
1. Отправить содержимое ветки в свой удаленный репозиторий (`git push origin имя_ветки`).
1. Создать пул-запрос в репозиторий группы и ждать результата


## Дополнительное задание

1. Создать собственные классы исключений.
1. Вывести информацию по всем дублирующим записям адрессов.
2. Подсчитать количество людей проживающих на 2, 3... этаже