package models;

import java.util.HashMap;

public class Model {

    private HashMap<String, String> dictionary;

    public Model() {
        dictionary = new HashMap<>();
        initDictionary();
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }



    private void initDictionary() {
        dictionary.put("apple", "яблоко");
        dictionary.put("add", "добавить");
        dictionary.put("angry", "злой");
        dictionary.put("baby", "малыш");
        dictionary.put("break", "разбить");
        dictionary.put("big", "большой");
        dictionary.put("cat", "кот");
        dictionary.put("catch", "поймать");
        dictionary.put("cold", "холодный");
        dictionary.put("dog", "собака");
        dictionary.put("do", "делать");
        dictionary.put("deep", "глубокий");
        dictionary.put("eagle", "орел");
        dictionary.put("eat", "есть");
        dictionary.put("every", "каждый");
        dictionary.put("final", "финал");
        dictionary.put("fight", "драться");
        dictionary.put("fat", "жирный");
        dictionary.put("group", "группа");
        dictionary.put("go", "идти");
        dictionary.put("great", "великолепный");
        dictionary.put("home", "дом");
        dictionary.put("hope", "надеяться");
        dictionary.put("hot", "жаркий");
        dictionary.put("ice", "лёд");
        dictionary.put("ignore", "игнорировать");
        dictionary.put("iron", "железный");
        dictionary.put("job", "работа");
        dictionary.put("jump", "прыгать");
        dictionary.put("just", "только");
        dictionary.put("king", "король");
        dictionary.put("kill", "убивать");
        dictionary.put("kind", "добрый");
        dictionary.put("left", "левый");
        dictionary.put("lead", "лидировать");
        dictionary.put("lamp", "лампа");
        dictionary.put("milk", "молоко");
        dictionary.put("meet", "встретить");
        dictionary.put("mad", "сумасшедший");
        dictionary.put("nose", "нос");
        dictionary.put("no", "нет");
        dictionary.put("never", "никогда");
        dictionary.put("old", "старый");
        dictionary.put("open", "открыть");
        dictionary.put("orange", "апельсин");
        dictionary.put("player", "игрок");
        dictionary.put("play", "играть");
        dictionary.put("pink", "розовый");
        dictionary.put("question", "вопрос");
        dictionary.put("quit", "выход");
        dictionary.put("quick", "быстрый");
        dictionary.put("river", "река");
        dictionary.put("red", "красный");
        dictionary.put("rise", "поднимать");
        dictionary.put("right", "правый");
        dictionary.put("salt", "соль");
        dictionary.put("see", "смотреть");
        dictionary.put("slow", "медленный");
        dictionary.put("this", "этот");
        dictionary.put("think", "думать");
        dictionary.put("tall", "высокий");
        dictionary.put("unit", "блок");
        dictionary.put("use", "использовать");
        dictionary.put("ugly", "гадкий");
        dictionary.put("volt", "вольт");
        dictionary.put("view", "вид");
        dictionary.put("very", "очень");
        dictionary.put("wind", "ветер");
        dictionary.put("wait", "ждать");
        dictionary.put("white", "белый");
        dictionary.put("xenon", "ксенон");
        dictionary.put("xerox", "копировать");
        dictionary.put("yes", "да");
        dictionary.put("yet", "ещё");
        dictionary.put("yellow", "жёлтый");
        dictionary.put("zero", "ноль");
        dictionary.put("zoom", "увеличивать");
        dictionary.put("zoo", "зоопарк");
    }
}
