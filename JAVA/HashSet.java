class MyHashSet {
    int size = 100;
    List<LinkedList<Integer>> arrList = new ArrayList<LinkedList<Integer>>(size);

    public MyHashSet() {
        for(int i = 0; i < size; i++){
            arrList.add(new LinkedList<Integer>());
        }
    }

    int hash(int key){
        return key % size;
    }

    int search(int key){
        int index = hash(key);
        
        for(int i = 0; i < arrList.get(index).size(); i++){
            if(arrList.get(index).get(i) == key){
                return i;
            }
        }
        return -1;
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }
        int index = hash(key);
        arrList.get(index).addLast(key);
    }
    
    public void remove(int key) {
        if(!contains(key)){
            return;
        }
        int index = hash(key);
        int pos = search(key);
        arrList.get(index).remove(pos);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        if(search(key) != -1){
            return true;
        }
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
