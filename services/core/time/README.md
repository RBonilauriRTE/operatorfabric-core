# OperatorFabric - Core - Time Management Service

This sub project manages Third Party Business Module registration

## 1. Set up and Build

see [OperatorFabric main page](../../../README.md)

## 2. Features

This service allows to manage the reference time of OperatorFabric services along
with the speed of the time flow. This service don't allow translation of
Third party services provided data. The (not mandatory) time synchronization
is the sole responsibility of the third party services

## 3. Rest Endpoints and Data Model

See [swagger generated documentation](https://opfab.github.io/projects/services/core/time/0.1.1.SNAPSHOT/api/index.html)

## 4. Disclaimer

The original functionalities of the deprecated gridos project included features
to make time "jump" at the closes previous or next card start time. For
now these features are not included in this service
