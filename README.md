# Sport Vehicle Tracker

A sleek Java Swing application that allows users to track and view details of popular sport vehicles like Porsche, Ferrari, and Lamborghini. The application features an intuitive interface inspired by modern design principles.

## Features

- **Vehicle Selection**: Choose from well-known brands.
- **Detailed Information**: View vehicle details including:
  - Name
  - Price
  - 0-100 km/h acceleration time
  - Engine size
- **Dynamic UI**: The interface updates based on the selected vehicle.
- **User-Friendly**: Simple and clean design for a seamless experience.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a simple text editor

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/sport-vehicle-tracker.git
   ```
2. Navigate to the project directory:
   ```bash
   cd sport-vehicle-tracker
   ```
3. Ensure you have the `cars.txt` file in the project root, formatted as follows:
   ```
   VehicleName,Price,ZeroToHundred,EngineSize
   ```
   Example:
   ```
   Porsche 911,100000,3.5,3.0
   Ferrari 488,250000,3.0,3.9
   Lamborghini Huracan,200000,3.2,5.2
   ```

### Running the Application

1. Open the project in your IDE or compile using the command line.
2. Run the `SportVehicleTracker` class. The GUI should launch, allowing you to select a vehicle and view its details.

## Contributing

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add some feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/YourFeature
   ```
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
