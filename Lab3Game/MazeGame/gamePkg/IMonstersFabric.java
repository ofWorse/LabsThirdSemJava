package gamePkg;

public interface IMonstersFabric {
    IMonster createWeakMonster();
    IMonster createAverageMonster();
    IMonster createSuperMonster();
}
