package Projects.Marselle.models.furniture.standartPositions.materials;

import org.springframework.stereotype.Component;

// В этом классе находится информация о стандартной фурнитуре
// TODO добавить автоматическое обновление цены на каждый тип
@Component
public class AccessoryDatabase {

    // Возвращает шурупы 16 Х 3.5
    public static Accessory getScrew16x3(int count) {
        Accessory screw = new Accessory();
            screw.setName("Шуруп универсальный 3,5х16 мм (белый цинк)");
            screw.setArticleNumber("ЦБ063451");
            screw.setProvider("КДМ");
            screw.setPrice(0.38);
            screw.setCount(count);

            return screw;
    }

    // Возвращает полкодержатель
    public static Accessory getShelfHolder(int count) {
        Accessory shelfHolder = new Accessory();
        shelfHolder.setName("Полкодержатель \"Ось с бортом\" 5х16 мм");
        shelfHolder.setArticleNumber("ЦБ004417");
        shelfHolder.setProvider("КДМ");
        shelfHolder.setPrice(0.69);
        shelfHolder.setCount(count);

        return shelfHolder;
    }

    // Возвращает шурупы 16 Х 3.5
    public static Accessory getScrew50x4(int count) {
        Accessory screw = new Accessory();
        screw.setName("Саморез 3,5х50 желтый");
        screw.setArticleNumber("-");
        screw.setProvider("Unknown");
        screw.setPrice(2.00);
        screw.setCount(count);

        return screw;
    }

    // Возвращает шурупы 16 Х 4
    public static Accessory getScrew16x4(int count) {
        Accessory screw = new Accessory();
        screw.setName("Шуруп универсальный 4,0х16 мм (белый цинк)");
        screw.setArticleNumber("ЦБ063452");
        screw.setProvider("КДМ");
        screw.setPrice(0.53);
        screw.setCount(count);

        return screw;
    }

    // Возвращает шурупы 30 Х 4
    public static Accessory getScrew30x4(int count) {
        Accessory screw = new Accessory();
        screw.setName("Шуруп универсальный 4,0х30 мм (белый цинк)");
        screw.setArticleNumber("ЦБ063454");
        screw.setProvider("КДМ");
        screw.setPrice(0.76);
        screw.setCount(count);

        return screw;
    }

    // Возвращает конфирмат 50 Х 6.3
    public static Accessory getConfirmat50x6(int count) {
        Accessory screw = new Accessory();
        screw.setName("Евровинт КДМ 6,3х50 мм (цинк)");
        screw.setArticleNumber("ЦБ004746");
        screw.setProvider("КДМ");
        screw.setPrice(1.09);
        screw.setCount(count);

        return screw;
    }

    // Возвращает ручку рейлинг 224
    public static Accessory getHandleRailing224(int count) {
        Accessory screw = new Accessory();
        screw.setName("Ручка-рейлинг EVA d10/224 мм (матовый хром)");
        screw.setArticleNumber("ЦБ035754");
        screw.setProvider("КДМ");
        screw.setPrice(102.17);
        screw.setCount(count);

        return screw;
    }

    // Возвращает ручку рейлинг 128
    public static Accessory getHandleRailing128(int count) {
        Accessory screw = new Accessory();
        screw.setName("Ручка-рейлинг EVA d10/128 мм (хром)");
        screw.setProvider("КДМ");
        screw.setArticleNumber("ЦБ010127");
        screw.setPrice(53.49);
        screw.setCount(count);

        return screw;
    }

    // Возвращает ручку рейлинг 96
    public static Accessory getHandleRailing96(int count) {
        Accessory screw = new Accessory();
        screw.setName("Ручка-рейлинг EVA d12/96 мм (матовый хром)");
        screw.setArticleNumber("ЦБ010214");
        screw.setProvider("КДМ");
        screw.setPrice(60.56);
        screw.setCount(count);

        return screw;
    }

    // Возвращает внутреннюю петлю
    public static Accessory getFurnitureHingesInternal(int count) {
        Accessory screw = new Accessory();
        screw.setName("Петля КДМ вкладная Clip on с доводчиком");
        screw.setArticleNumber("ЦБ008959");
        screw.setProvider("КДМ");
        screw.setPrice(49.69);
        screw.setCount(count);

        return screw;
    }

    // Возвращает накладную петлю
    public static Accessory getFurnitureHingesExternal(int count) {
        Accessory screw = new Accessory();
        screw.setName("Петля КДМ накладная Clip-On с доводчиком");
        screw.setArticleNumber("ЦБ009019");
        screw.setProvider("КДМ");
        screw.setPrice(29.55);
        screw.setCount(count);

        return screw;
    }

    // Возвращает уголок
    public static Accessory getFurnitureCorner(int count) {
        Accessory screw = new Accessory();
        screw.setName("Уголок 20х20х16х1,5 (металл)");
        screw.setArticleNumber("ЦБ039631");
        screw.setProvider("КДМ");
        screw.setPrice(3.90);
        screw.setCount(count);

        return screw;
    }

    // Возвращает уголок усиленный (для зеркал, гримерок и т.д.)
    public static Accessory getFurnitureCornerReinforced(int count) {
        Accessory screw = new Accessory();
        screw.setName("KUU-50 Крепежный уголок усиленный (50х50х35х2,0)");
        screw.setArticleNumber("00000000784");
        screw.setProvider("Крепеж");
        screw.setPrice(7.60);
        screw.setCount(count);

        return screw;
    }

    // Возвращает футорку
    public static Accessory getAdjustableSupport(int count) {
        Accessory screw = new Accessory();
        screw.setName("Опора регулируемая М-6 (Футорка)");
        screw.setArticleNumber("ЦБ008898");
        screw.setProvider("КДМ");
        screw.setPrice(10.83);
        screw.setCount(count);

        return screw;
    }

    // Возвращает направляющую 250
    public static Accessory getGuide250(int count) {
        Accessory screw = new Accessory();
        screw.setName("Направляющие шариковые GMF 35х250 мм");
        screw.setArticleNumber("ЦБ008531");
        screw.setProvider("КДМ");
        screw.setPrice(171.52); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает направляющую 300
    public static Accessory getGuide300(int count) {
        Accessory screw = new Accessory();
        screw.setName("Направляющие шариковые GMF 35х300 мм");
        screw.setArticleNumber("ЦБ008532");
        screw.setProvider("КДМ");
        screw.setPrice(128.20); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает направляющую 350
    public static Accessory getGuide350(int count) {
        Accessory screw = new Accessory();
        screw.setName("Направляющие шариковые GMF 35х350 мм");
        screw.setArticleNumber("ЦБ008533");
        screw.setProvider("КДМ");
        screw.setPrice(80.09); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает направляющую 400
    public static Accessory getGuide400(int count) {
        Accessory screw = new Accessory();
        screw.setName("Направляющие шариковые GMF 35х400 мм");
        screw.setArticleNumber("ЦБ008534");
        screw.setProvider("КДМ");
        screw.setPrice(134.28); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает направляющую 450
    public static Accessory getGuide450(int count) {
        Accessory screw = new Accessory();
        screw.setName("Направляющие шариковые GMF 35х450 мм");
        screw.setArticleNumber("ЦБ008535");
        screw.setProvider("КДМ");
        screw.setPrice(150.24); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает трубу
    public static Accessory getPipe(int count) {
        Accessory screw = new Accessory();
        screw.setName("Штанга круглая d=25х0,7х3000мм, хром (GMF)");
        screw.setArticleNumber("ЦБ022074");
        screw.setProvider("КДМ");
        screw.setPrice(232.51); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает флянец
    public static Accessory getFlange(int count) {
        Accessory screw = new Accessory();
        screw.setName("Фланец для трубы 16мм (хром)");
        screw.setArticleNumber("ЦБ011070");
        screw.setProvider("КДМ");
        screw.setPrice(12.68); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает флянец
    public static Accessory getWheel(int count) {
        Accessory screw = new Accessory();
        screw.setName("Опора колесная d40 мм с площадкой и стопором (черный)");
        screw.setArticleNumber("ЦБ008875");
        screw.setProvider("КДМ");
        screw.setPrice(23.80); //TODO
        screw.setCount(count);

        return screw;
    }

    // Возвращает опору для стола
    public static Accessory getSupportLeg710(int count) {
        Accessory screw = new Accessory();
        screw.setName("Опора офисная 60х710 мм усы (GMF) (хром)");
        screw.setArticleNumber("ЦБ008779");
        screw.setProvider("КДМ");
        screw.setPrice(295.45); //TODO
        screw.setCount(count);

        return screw;
    }

    public static Accessory getMirror(int length, int width,int count) {
        Accessory mirror = new Accessory();
        mirror.setName("Зеркало " + length + "x" + width);
        mirror.setArticleNumber("-");
        mirror.setProvider("-");
        mirror.setPrice(700.0); //TODO Неизвестно
        mirror.setCount(count);

        return mirror;
    }

    public static Accessory getMirrorHolder(int count) {
        Accessory screw = new Accessory();
        screw.setName("Держатель зеркала");
        screw.setArticleNumber("-");
        screw.setProvider("-");
        screw.setPrice(3.0); //TODO Неизвестно
        screw.setCount(count);

        return screw;
    }

    public static Accessory getScrew20x3(int count) {
        Accessory screw = new Accessory();
        screw.setName("Универсальный саморез 20х3,0 мм");
        screw.setArticleNumber("-");
        screw.setProvider("-");
        screw.setPrice(0.72); //TODO Неизвестно
        screw.setCount(count);

        return screw;
    }
    public static Accessory getCartridgeE27(int count) {
        Accessory сartridge = new Accessory();
        сartridge.setName("Патрон для лампочки");
        сartridge.setArticleNumber("-");
        сartridge.setProvider("-");
        сartridge.setPrice(40.0); //TODO Неизвестно
        сartridge.setCount(count);

        return сartridge;
    }

    public static Accessory getWire075x2(int count) {
        Accessory wire = new Accessory();
        wire.setName("Провод 2 х 0.75 " + count + " метров");
        wire.setArticleNumber("-");
        wire.setProvider("-");
        wire.setPrice(24.0 * count); //TODO Неизвестно
        wire.setCount(count);

        return wire;
    }

    public static Accessory getWireWithPlug(int count) {
        Accessory wire = new Accessory();
        wire.setName("Шнур для бра с проходным выключателем, белый ШВВП 2х0,75 1,7м");
        wire.setArticleNumber("-");
        wire.setProvider("-");
        wire.setPrice(158.0); //TODO Неизвестно
        wire.setCount(count);

        return wire;
    }

    public static Accessory getPressureRing(int count) {
        Accessory wire = new Accessory();
        wire.setName("Кольцо прижимное для патрона");
        wire.setArticleNumber("-");
        wire.setProvider("-");
        wire.setPrice(19.0); //TODO Неизвестно
        wire.setCount(count);

        return wire;
    }

}
