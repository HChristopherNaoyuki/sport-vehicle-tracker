package Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class SportVehicleTracker extends JFrame
{
    private final JRadioButton btnPorsche, btnFerrari, btnLamborghini;
    private final JButton btnSubmit;
    private final DefaultListModel<String> listModel;
    private ArrayList<Vehicle> vehicles;

    public SportVehicleTracker()
    {
        setTitle("Sport Vehicles");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240));

        btnPorsche = createRadioButton();
        btnFerrari = createRadioButton();
        btnLamborghini = createRadioButton();
        ButtonGroup group = new ButtonGroup();
        group.add(btnPorsche);
        group.add(btnFerrari);
        group.add(btnLamborghini);

        btnSubmit = createButton("SUBMIT");
        listModel = new DefaultListModel<>();
        JList<String> vehicleList = new JList<>(listModel);
        vehicleList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        radioPanel.setBackground(new Color(240, 240, 240));
        radioPanel.add(btnPorsche);
        radioPanel.add(btnFerrari);
        radioPanel.add(btnLamborghini);

        add(radioPanel, BorderLayout.NORTH);
        add(btnSubmit, BorderLayout.CENTER);
        add(new JScrollPane(vehicleList), BorderLayout.SOUTH);

        loadVehicleData();

        btnSubmit.addActionListener((ActionEvent e) -> displayVehicleDetails());
        if (!vehicles.isEmpty())
        {
            btnPorsche.setSelected(true);
        }
    }

    private JRadioButton createRadioButton()
    {
        JRadioButton radioButton = new JRadioButton();
        radioButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        radioButton.setBackground(new Color(240, 240, 240));
        radioButton.setFocusPainted(false);
        return radioButton;
    }

    private JButton createButton(String text)
    {
        JButton button = new JButton(text);
        button.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        button.setBackground(new Color(0, 122, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void loadVehicleData()
    {
        vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");
                if (data.length == 4)
                {
                    vehicles.add(new Vehicle(data[0].trim(),
                                             Double.parseDouble(data[1].trim()),
                                             Double.parseDouble(data[2].trim()),
                                             Double.parseDouble(data[3].trim())));
                }
                else
                {
                    showMessage("Invalid data format in file.");
                }
            }
            if (vehicles.size() > 0)
            {
                btnPorsche.setText(vehicles.get(0).getName());
            }
            if (vehicles.size() > 1)
            {
                btnFerrari.setText(vehicles.get(1).getName());
            }
            if (vehicles.size() > 2)
            {
                btnLamborghini.setText(vehicles.get(2).getName());
            }
        }
        catch (IOException | NumberFormatException e)
        {
            showMessage("Error loading vehicle data: " + e.getMessage());
        }
    }

    private void displayVehicleDetails()
    {
        listModel.clear();
        int selectedIndex = btnPorsche.isSelected() ? 0 : btnFerrari.isSelected() ? 1 : btnLamborghini.isSelected() ? 2 : -1;

        if (selectedIndex >= 0 && selectedIndex < vehicles.size())
        {
            Vehicle vehicle = vehicles.get(selectedIndex);
            listModel.addElement(vehicle.getName());
            listModel.addElement("Price: R " + vehicle.getPrice());
            listModel.addElement("0 - 100: " + vehicle.getZeroToHundred() + " seconds");
            listModel.addElement("Engine: " + vehicle.getEngineSize() + " litre");
        }
        else
        {
            showMessage("Please select a vehicle.");
        }
    }

    private void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    class Vehicle
    {
        private final String name;
        private final double price, zeroToHundred, engineSize;

        public Vehicle(String name, double price, double zeroToHundred, double engineSize)
        {
            this.name = name;
            this.price = price;
            this.zeroToHundred = zeroToHundred;
            this.engineSize = engineSize;
        }

        public String getName()
        {
            return name;
        }

        public double getPrice()
        {
            return price;
        }

        public double getZeroToHundred()
        {
            return zeroToHundred;
        }

        public double getEngineSize()
        {
            return engineSize;
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            SportVehicleTracker app = new SportVehicleTracker();
            app.setVisible(true);
        });
    }
}
