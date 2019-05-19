var sellers = [];

function findProduct (sellerId) {
  return products[findProductKey(productId)];
}

function findProductKey (sellerId) {
  for (var key = 0; key < sellers.length; key++) {
    if (products[key].id == productId) {
      return key;
    }
  }
}

var sellerService = {
  findAll(fn) {
    axios
      .get('/api/v1/sellers')
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  findById(id, fn) {
    axios
      .get('/api/v1/sellers/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(seller, fn) {
    axios
      .post('/api/v1/sellers', seller)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  update(id, seller, fn) {
    axios
      .put('/api/v1/sellers/' + id, seller)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  deleteSeller(id, fn) {
    axios
      .delete('/api/v1/sellers/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  }
}

var List = Vue.extend({
  template: '#seller-list',
  data: function () {
    return {sellers: [], searchKey: ''};
  },
  computed: {
    filteredSellers() {
      return this.sellers.filter((seller) => {
      	return seller.name.indexOf(this.searchKey) > -1
      	  || seller.address.indexOf(this.searchKey) > -1
      	  || seller.contactNo.toString().indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    productService.findAll(r => {this.sellers = r.data; sellers = r.data})
  }
});

var Seller = Vue.extend({
  template: '#seller',
  data: function () {
    return {seller: findSeller(this.$route.params.seller_id)};
  }
});

var SellerEdit = Vue.extend({
  template: '#seller-edit',
  data: function () {
    return {seller: findSeller(this.$route.params.seller_id)};
  },
  methods: {
    updateSeller: function () {
    	sellerService.update(this.seller.id, this.seller, r => router.push('/'))
    }
  }
});

var SellerDelete = Vue.extend({
  template: '#seller-delete',
  data: function () {
    return {seller: findSeller(this.$route.params.seller_id)};
  },
  methods: {
    deleteSeller: function () {
    	sellerService.deleteSeller(this.seller.id, r => router.push('/'))
    }
  }
});

var AddSeller = Vue.extend({
  template: '#add-seller',
  data() {
    return {
    	seller: {name: '', description: '', price: 0}
    }
  },
  methods: {
    createSeller() {
    	sellerService.create(this.seller, r => router.push('/'))
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: List},
		{path: '/seller/:seller_id', component: Product, name: 'seller'},
		{path: '/add-seller', component: AddProduct},
		{path: '/seller/:seller_id/edit', component: ProductEdit, name: 'seller-edit'},
		{path: '/seller/:seller_id/delete', component: SellerDelete, name: 'seller-delete'}
	]
});

new Vue({
  router
}).$mount('#app')