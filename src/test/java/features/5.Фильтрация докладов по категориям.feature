#language:ru
@test
Функционал:Фильтрация докладов по категориям

  Сценарий:Фильтрация докладов по категориям
    Пусть пользователь заходит на сайт и переходит на вкладку Talks Library
    И пользователь нажимает на More Filters
    Когда пользователь выбирает: Category – Testing, Location – Belarus, Language – English, На вкладке фильтров
    Тогда на странице отображаются карточки соответствующие правилам выбранных фильтров
