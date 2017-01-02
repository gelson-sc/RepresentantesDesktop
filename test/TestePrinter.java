
import br.com.controller.print.ImprimirDados;
import br.com.model.Pedido;
import br.com.model.Produto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class TestePrinter {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        List<Produto> lista = new ArrayList<Produto>();
        ImprimirDados print = new ImprimirDados();
        boolean printed = false;
        boolean sendServer = false;
        // criar objeto pedido
        Pedido p = new Pedido();
        p.setId(0);
        p.setCodBarras("712345678910");
        p.setCliente("Cliente X");
        p.setData(new Date());
        p.setTransmitido(false);

        for (int i = 0; i < 5; i++) {
            Produto prod = new Produto();
            prod.setId(i);
            prod.setCategoria("Brinquedos");
            prod.setCodigo("21.33.44.55");
            prod.setTipo("A2");
            prod.setValor(1);
            lista.add(prod);
        }

        p.setProdutos(lista);
        p.setTotal();

        printed = print.imprimirPedido(p);
        if (printed) {
            int opcao = JOptionPane.showConfirmDialog(null, "Impressão correta?", "Confirma", JOptionPane.YES_NO_OPTION);
            if (opcao == 0) {
                print.imprimirRodape(p);

                if (sendServer) {
                    p.setTransmitido(true);
                }

            } else {
                System.out.print(":p");
            }

        }

    }
}
