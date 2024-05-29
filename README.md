## Результат выполениея тестового дазания

# Реализовано:
- Первый эркран. Имя и фвмилия подгружаются из локального кэша (в нашем случае это stateflow в синглтоне). Навигация по кнопкам по ТЗ
- Второй экран. Валидация полей по ТЗ, При открытой клавиатуре элементы скролятся. Введенные данные сохраняются в модельку и отправляются в кэш через репозиторий
- Третий экран. raw json имитирует запрос из сети, парсится с помощью kotlinx serialization, преобразуется к нужному виду и отображается в списке LazyColumn

# Стек технологий
- Использованы принципы чистой архитектуры, но без усложнений, так как приложение небольшое. То есть например на стартовом экране viewmodel напрямую обращается в data слой через репозиторий. В ui слое примен паттерн mvi (кроме начального экрана, где вьюмодель служит только для подписки на имя и фамилию
- di через dagge hilt, навигация через voyager (более удобная навигация чем compose navigation, + она мультиплатформенная)
- Стили, цыета и общие ui элементы вынесены отдельно - дизайн система на минималках

  Демонстрация работы: https://disk.yandex.ru/i/FaGH78urvM7LJQ
  