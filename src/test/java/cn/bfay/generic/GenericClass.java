package cn.bfay.generic;

/**
 * 泛型类.在类GenericClass的作用域中，<K, V是泛型类型参数.
 *
 * @author wangjiannan
 */
class GenericClass<K, V> {
    private K k;
    private V v;

    GenericClass(K k, V v) {
        this.k = k;
        this.v = v;
    }

    K getK() {
        return k;
    }

    V getV() {
        return v;
    }

}
