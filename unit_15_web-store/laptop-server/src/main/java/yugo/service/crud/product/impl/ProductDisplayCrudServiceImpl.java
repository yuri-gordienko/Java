//package yugo.service.crud.product.impl;
//
//import lombok.AllArgsConstructor;
//import org.springframework.data.domain.Page;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import yugo.data.datatable.DataTableRequest;
////import yugo.persistence.sql.entity.product.ProductDisplay;
//import yugo.persistence.sql.repository.product.ProductDisplayRepository;
//import yugo.service.crud.product.ProductDisplayCrudService;
//import yugo.util.IsValidFields;
//import yugo.util.PersistenceUtil;
//
//@Service
//@Transactional
//@AllArgsConstructor
//public class ProductDisplayCrudServiceImpl implements ProductDisplayCrudService {
//
//    private final ProductDisplayRepository productDisplayRepository;
//    private final IsValidFields isValidFields;
//
//    @Override
//    public void create(ProductDisplay productDisplay) {
//
//        productDisplayRepository.save(productDisplay);
//    }
//
//    @Override
//    public void update(ProductDisplay productDisplay) {
//        isValidFields.isValidId(productDisplay.getId());
//        productDisplayRepository.save(productDisplay);
//    }
//
//    @Override
//    public void delete(Long id) {
//        isValidFields.isValidId(id);
//        productDisplayRepository.deleteById(id);
//    }
//
//    @Override
//    public ProductDisplay findById(Long id) {
//        isValidFields.isValidId(id);
//        return productDisplayRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//    }
//
//    @Override
//    public Page<ProductDisplay> findAll(DataTableRequest request) {
//        return productDisplayRepository.findAll(PersistenceUtil.generatePageableByDataTableRequest(request));
//    }
//}
