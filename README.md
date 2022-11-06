# Работа с XML

**Цель работы:** научится читать и использовать содержимое XML-файлов,

## Представление данных в программе

Нужно создать класс **Client** для хранения информации о клиенте. Пример класса:
```
public struct Client {
    public int id;                 // идентификатор
    public String name;            // ФИО
    public String personnelNumber; // персональный номер
    public Address address;        // адресс проживания
} 
```
класс **Address** для хранения адреса проживания клиента. Пример:

```
public struct Address {
    public int id;           // идентификатор
    public String city;      // город
    public String street;    // улица
    public int house;        // дом
    public int floor;        // этаж
    public int flatNumber;   // квартира
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
                        String id = parser.getAttributeValue(0);
                        String city = parser.getAttributeValue(1);
                        String street = parser.getAttributeValue(2);
                        int house = Integer.parseInt(parser.getAttributeValue(3));
                        int floor = Integer.parseInt(parser.getAttributeValue(4));
                        int flatNumber = Integer.parseInt(parser.getAttributeValue(5));
                        Address address = new Address(id, city, street, house, floor, flatNumber);
                        addressList.add(address);
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