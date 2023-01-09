package gamePkg.menu;

import gamePkg.enums.Situation;

import java.util.Random;

public class MenuOfDescriptions {

    public void describeTheSituation(Situation situation) {
        var randDesc = new Random().nextInt(3);

        switch (situation) {
            case ROOM_DESCRIPTION -> randomRoomDescription(randDesc);
            case WALL_DESCRIPTION -> randomWallDescription(randDesc);
            case DOOR_DESCRIPTION -> randomDoorDescription(randDesc);
            case ENEMY_DESCRIPTION -> {
                System.out.println("\n ВНЕЗАПНО, какой то монстр решил на вас напасть!");
                System.out.println("Сразитесь с ним, чтобы выжить и продолжить поиски!");
            }
            case PORTAL_DESCRIPTION -> {
                System.out.println("\nВот это да... Вы нашли портал, а значит и выход из этого лабиринта.");
                System.out.println("Вы можете покинуть этот лабиринт, в следствии, игра закончится, но");
                System.out.println("вы также можете побродить по лабиринту и найти еще больше приключений.");
                System.out.println("Для вас главное, чтобы они не завершились летальным исходом...");
            }
            case FIGHT_RESULT_DESCRIPTION -> {

            }
            case IGNORED -> System.out.println("\nВы проигнорировали действие.");
            case ROOM_IS_EMPTY -> System.out.println("\nВ этой комнате ничего нет.");
            case ROOM_IS_NOT_EMPTY -> System.out.println("\nВ этой комнате есть: ");
            case YOU_ARE_DEAD -> randomDeathDescription(randDesc);
            case MONSTER_IS_DEAD -> System.out.print("\n МОНСТР УБИТ (ИЛИ УБЕЖАЛ)!!!\nРезультат боя: ");
            case YOU_DROPPED_THE_ITEM -> System.out.println("\nВы выбросили предмет.");
        }
    }

    private void randomDeathDescription(int rand) {
        switch (rand) {
            case 0 -> {
                System.out.println("\nПочувствовав резкую боль и легкий холод,");
                System.out.println("вы упали, постепенно перестав чувствовать свои ноги,");
                System.out.println("руки, тело... Поняв, что ваша судьба предрешена, ");
                System.out.println("вы решили не стараться что-то вернуть и забыть о своем существовании.");
            }
            case 1 -> {
                System.out.println("\nПодпирая рукой распоротый живот, вы попытались дать отпор");
                System.out.println("врагу, но всё тщетно. Сил уже нет, в глазах начало темнеть,");
                System.out.println("остается только взглянуть смерти в глаза и ждать последний удар.");
            }
            case 2 -> {
                System.out.println("\nУпав с треском о пол, вы почувствовали, как повредили");
                System.out.println("теменную часть. Кровь начала сочиться из вашей черепушки.");
                System.out.println("В ушах гулял белый шум, а подбородок подрагивал от контузии.");
                System.out.println("Вы поняли, что пришёл ваш черёд прощаться с этим миром,");
                System.out.println("уснув в последний раз в этой жизни...");
            }
        }

    }

    private void randomDoorDescription(int rand) {
        switch (rand) {
            case 0 -> {
                System.out.println("\nДверь с такими металлическими ставнями вряд-ли просто так вам поддастся...");
                System.out.println("Стоит попробовать, но на многое я бы не надеялся.");
            }
            case 1 -> {
                System.out.println("\nЭта дверь будто бы взята из лечебной для палаты психически больных...");
                System.out.println("Можете попробовать ее открыть, если не брезгаете испачкаться в крови.");
            }
            case 2 -> {
                System.out.println("\nТакое дверью назвать трудно, но если это единственный путь к следующей");
                System.out.println("комнате... Дело ваше.");
            }
        }
    }

    private void randomWallDescription(int rand) {
        switch (rand) {
            case 0 -> {
                System.out.println("\nТолько посмотрите на эти стены. Эти пугающие картины будто бы смотрят вам в");
                System.out.println("душу... Будем надеяться что это просто ваша шизофрения.");
            }
            case 1 -> {
                System.out.println("\nЭти следы крови выглядят так, будто бы они были оставлены совсем недавно...");
                System.out.println("Кто бы мог такое сделать... и с кем..?");
            }
            case 2 -> {
                System.out.println("\nДыры в этих стенах были проделаны явно не человеком... А может быть и человеком ");
                System.out.println("Но не находящимся в своем сознании... ");
            }
        }
    }

    private void randomRoomDescription(int rand) {
        switch (rand) {
            case 0 -> {
                System.out.println("\nТёмный, мрачный коридор. Вы на цыпочках как вор вошли в темное помещение не");
                System.out.println("имея понятия, что может находиться по по ту сторону темных стен.");
            }
            case 1 -> {
                System.out.println("\nВы находитесь в белой комнате, которую освещают десятки белых и одинаковых");
                System.out.println("ламп. Все стены, пол и потолок измазаны яркими брызгами крови, будто-бы ");
                System.out.println("кто-то нарочно натирал эти стены чьим то вспоротым телом.");
            }
            case 2 -> {
                System.out.println("\nВы вошли в комнату, сделанную из прогнившей древесины, из которой выползали ");
                System.out.println("мелкие белые опарыши. Отовсюду пахло гнилью и сыростью. ");
            }
        }
    }


}
