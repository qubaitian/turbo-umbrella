const app = new Vue({
  el: '#app',
  data: {
    books: [
      {
        id: 1,
        name: '算法导论',
        date: '2006-9',
        price: 85.00,
        count: 1
      }, {
        id: 2,
        name: '算法导论',
        date: '2006-9',
        price: 85.00,
        count: 1
      }, {
        id: 3,
        name: '算法导论',
        date: '2006-9',
        price: 85.10,
        count: 1
      }, {
        id: 4,
        name: '算法导论',
        date: '2006-9',
        price: 85.10,
        count: 1
      },
    ]
  },
  methods: {
    increment(item) {
      item.count++;
    },
    decrement(item) {
      item.count--;
    },
    removeC(index) {
      console.log(index);
      this.books.splice(index, 1)
    }
    //vue自动把0省略,所以用toFixed()占位
    // getFinalPrice(price) {
    //   // return '$'+price;
    //   return '$' + price.toFixed(2);
    // }
  },
  computed: {
    totalPrice() {
      //普通for循环 使用let和java的变量一样
      let totalPrice = this.books.reduce((pre, item) => (pre + item.price*item.count),0);
      // for (let i=0;i<this.books.length;i++){
      //   totalPrice+=this.books[i].price*this.books[i].count
      // }
      // for (let i in this.books){
      //   totalPrice+=this.books[i].price*this.books[i].count;
      // }
      // for(let item of this.books){
      //   totalPrice+=item.price*item.count
      // }
      return totalPrice;
    }
  },
  filters: {
    showPrice(price) {
      return '$' + price.toFixed(2);
    }
  }
});

