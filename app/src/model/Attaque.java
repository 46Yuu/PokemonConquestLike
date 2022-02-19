public abstract class Attaque {
    public void Attak(Pokemon p ){
        p.Pdv = p.Pdv - this.Atk;
    }
}
