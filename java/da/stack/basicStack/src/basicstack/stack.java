/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicstack;

/**
 *
 * @author olivermensah
 */
interface stack<X> {
    public void push();
    public  X pop();
    public boolean contains(X items);
    public X access(X item);
    public int size();
}
