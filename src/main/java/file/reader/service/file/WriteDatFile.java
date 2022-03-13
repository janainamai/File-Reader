package file.reader.service.file;

import file.reader.entities.Customer;
import file.reader.entities.Sale;
import file.reader.entities.Salesman;
import file.reader.service.CustomerService;
import file.reader.service.SaleService;
import file.reader.service.SalesmanService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDatFile {

    private static final SalesmanService salesmanService = new SalesmanService();
    private static final CustomerService customerService = new CustomerService();
    private static final SaleService saleService = new SaleService();

    public void createFileResult(String directoryAdress, List<String> records) {
        List<Salesman> salesmens = salesmanService.extractToSalesmanEntities(records);
        List<Customer> customers = customerService.extractToCustomerEntities(records);
        List<Sale> sales = saleService.extractToSaleEntities(records);

        Sale mostExpansiveSale = saleService.getMostExpansiveSale(sales);
        String worstSalesman = saleService.getWorstSalesmanEver(sales);

        try {
            File result = new File(directoryAdress);

            BufferedWriter writer = new BufferedWriter(new FileWriter(result));
            writer.write("Amount of clients in the input fileç" + customers.size());
            writer.newLine();
            writer.write("Amout of salesman in the input fileç" + salesmens.size());
            writer.newLine();
            writer.write("ID of the most expensive saleç" + mostExpansiveSale.getId());
            writer.newLine();
            writer.write("Worst salesman everç" + worstSalesman);
            writer.flush();

            result.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
