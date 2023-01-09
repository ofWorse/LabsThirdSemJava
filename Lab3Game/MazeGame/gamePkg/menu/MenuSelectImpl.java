package gamePkg.menu;

import gamePkg.IMenuSelect;
import gamePkg.enums.NumberMenu;

public class MenuSelectImpl implements IMenuSelect {

    @Override
    public void menuSelect(NumberMenu menuNumber) {
        switch (menuNumber) {
            case START_MENU -> {
                System.out.println("1) Начать игру.");
                System.out.println("2) Выйти из игры.");
                System.out.println("3) Правила игры.");
            }
            case RULES_MENU -> {
                System.out.println("\nДобро пожаловать в игру жанра RogueLike.");
                System.out.println("Здесь вам предстоит управлять главным героем,");
                System.out.println("который способен бродить по комнатам, обыскивать их,");
                System.out.println("подбирать/сохранять/выбрасывать предметы и драться с монстрами.");
                System.out.println("\nЦель игры - найти портал будучи живым и выбраться из лабиринта.");
                System.out.println("Управление производится при помощи выбора одного из предложенных");
                System.out.println("вариантов меню при помощи клавиш 1-9.\n");
                System.out.println("\nОсновные особенности игры:");
                System.out.println("\t1) В бою с монстром у главного героя есть способность парировать");
                System.out.println("\t   атаку. В этот момент, главный герой делает уворот и забирает");
                System.out.println("\t   определенное число здоровья, равное силе урона противника.");
                System.out.println("\t2) Вы также можете \"напугать\" монстра, дав отпор его удару, ");
                System.out.println("\t   тем самым, есть вероятность того, что монстр сбежит от вас.");
                System.out.println("\t3) Вы можете избежать боя, перейдя в предыдущую комнату.");
                System.out.println("\t   Это может потребоваться в том случае, если вы не подобрали");
                System.out.println("\t   полезный предмет в предыдущей комнате, или, если не подобрали");
                System.out.println("\t   предмет в комнате с монстром.");
                System.out.println("\t4) Если вы не подберете предмет \"с пола\", то он исчезнет.\n\n");
            }
            case ROOM_ENTRY_MENU -> System.out.println("\nВы вошли в комнату.\n");
            case LOOK_AROUND_MENU -> {
                System.out.println("\nОсмотреть комнату?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
            }
            case ACCEPT_FIGHT_MENU -> {
                System.out.println("\nКажется монстр хочет на вас напасть!");
                System.out.println("Что будете делать?");
                System.out.println("1) Начать бой.");
                System.out.println("2) Сбежать в другую комнату");
            }
                case FIGHT_MENU -> {
                System.out.println("\nВы в драке с монстром!");
                System.out.println("Ваши действия: ");
                System.out.println("1) Нанести удар.");
                System.out.println("2) Парировать.");
                System.out.println("3) Защититься.");
            }
            case ITEMS_MENU -> {
                System.out.println("\nВ этой комнате находятся кое какие предметы.");
                System.out.println("Обыскать её?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
            }
            case ARMOR_MENU -> {
                System.out.println("\nПеред вами броня. Подобрать её?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
                System.out.println("3) Положить в рюкзак.");
            }
            case ARMOR_MENU2 -> {
                System.out.println("\nДействие с броней: ");
                System.out.println("1) Надеть.");
                System.out.println("2) Отмена.");
            }
            case WEAPON_MENU -> {
                System.out.println("\nПеред вами оружие. Подобрать его?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
                System.out.println("3) Положить в рюкзак.");
            }
            case WEAPON_MENU2 -> {
                System.out.println("\nДействие с оружием: ");
                System.out.println("1) Взять в руки.");
                System.out.println("2) Отмена.");
            }
            case DOOR_MENU -> {
                System.out.println("\nВы подошли к двери. Открыть её?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
            }
            case PORTAL_MENU -> {
                System.out.println("\n1) Да.");
                System.out.println("2) Нет.");
            }
            case SCROLLER_MENU -> {
                System.out.println("\nПеред вами какой-то свиток магии. Прочесть его?");
                System.out.println("1) Да.");
                System.out.println("2) Нет.");
                System.out.println("3) Положить в рюкзак.");
            }
            case SCROLLER_MENU2 -> {
                System.out.println("\nДействие со свитком: ");
                System.out.println("1) Прочесть.");
                System.out.println("2) Отмена.");
            }
            case BACKPACK_START_MENU -> System.out.println("\n Выберите предмет из рюкзака (0 - отмена): ");
            case BACKPACK_ACT_MENU -> {
                System.out.println("\n Выберите действие: ");
                System.out.println("1) Применить.");
                System.out.println("2) Выбросить.");
            }
        }
    }
}
